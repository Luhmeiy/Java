import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {
        // Extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        // Popular a lista de conteúdos
        return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image")))
                .toList();
    }
}
