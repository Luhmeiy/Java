import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_BOLD = "\u001b[1m";

    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI uri = URI.create(url);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();
        // System.out.println(body);

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // System.out.println(listaDeFilmes.size());
        // System.out.println(listaDeFilmes.get(0));

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Título: " + ANSI_BOLD + filme.get("title") + ANSI_RESET);
            System.out.println("Poster: " + ANSI_BOLD + filme.get("image") + ANSI_RESET);
            System.out.println(ANSI_CYAN_BACKGROUND
                    + "Classificação: " + filme.get("imDbRating")
                    + ANSI_RESET);

            for (int i = 0; i < Math.round(Double.parseDouble(filme.get("imDbRating"))); i++) {
                System.out.print("\u2B50");
            }

            System.out.println("\n");
        }
    }
}
