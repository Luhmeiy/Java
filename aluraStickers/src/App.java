import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_BOLD = "\u001b[1m";

    public static void main(String[] args) throws Exception {
        // Fazer uma conexão HTTP e buscar os resultados
        API api = API.IMDB_TOP_TV;

        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Título: " + ANSI_BOLD + conteudo.titulo() + ANSI_RESET);
            System.out.println("Imagem: " + ANSI_BOLD + conteudo.urlImagem() + ANSI_RESET);

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
