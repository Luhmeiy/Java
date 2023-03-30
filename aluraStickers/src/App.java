import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_BOLD = "\u001b[1m";

    public static void main(String[] args) throws Exception {
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        // String url =
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-03-26&end_date=2022-03-28";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Título: " + ANSI_BOLD + conteudo.getTitulo() + ANSI_RESET);
            System.out.println("Imagem: " + ANSI_BOLD + conteudo.getUrlImagem() + ANSI_RESET);

            /*
             * System.out.println(ANSI_CYAN_BACKGROUND
             * + "Classificação: " + conteudo.getClassificacao()
             * + ANSI_RESET);
             * 
             * for (int c = 0; c <
             * Math.round(Double.parseDouble(conteudo.getClassificacao())); c++) {
             * System.out.print("\u2B50");
             * }
             */

            System.out.println("\n");
        }
    }
}
