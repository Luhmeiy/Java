import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {
        // Extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        // Popular a lista de conteúdos
        // STREAM VERSION
        return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
                .toList();

        // COMMON VERSION
        /*
         * List<Conteudo> conteudos = new ArrayList<>();
         * 
         * for (Map<String, String> atributos : listaDeAtributos) {
         * String titulo = atributos.get("title");
         * String urlImagem = atributos.get("url");
         * 
         * var conteudo = new Conteudo(titulo, urlImagem);
         * 
         * conteudos.add(conteudo);
         * }
         * 
         * return conteudos;
         */
    }
}
