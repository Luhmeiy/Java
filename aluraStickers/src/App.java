import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

        // Exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();

        for (Map<String, String> filme : listaDeFilmes) {
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            String classificacao = filme.get("imDbRating");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Título: " + ANSI_BOLD + titulo + ANSI_RESET);
            System.out.println("Poster: " + ANSI_BOLD + urlImagem + ANSI_RESET);
            System.out.println(ANSI_CYAN_BACKGROUND
                    + "Classificação: " + classificacao
                    + ANSI_RESET);

            for (int i = 0; i < Math.round(Double.parseDouble(classificacao)); i++) {
                System.out.print("\u2B50");
            }

            System.out.println("\n");
        }
    }
}
