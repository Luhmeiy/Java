import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // Leitura da imagem
        // InputStream inputStream =
        // new FileInputStream(new File("entrada/TopMovies_1.jpg"));
        // InputStream inputStream =
        // new URL(
        // "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte
        var fonte = new Font("Impact", Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // Escrever uma frase na nova imagem
        String mensagem = "TOPZERA";
        int textWidth = graphics.getFontMetrics().stringWidth(mensagem);
        int posicaoX = (largura - textWidth) / 2;
        int posicaoY = novaAltura - 64;
        graphics.drawString(mensagem, posicaoX, posicaoY);

        // Adicionar outline ao texto
        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(mensagem, fonte, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoX, posicaoY);
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(largura * 0.004f);
        graphics.setStroke(outlineStroke);

        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);

        // Escrever a nova imagem em um arquivo
        String nomeDiretorio = "saida/";

        File directory = new File(nomeDiretorio);
        if (!directory.exists()) {
            directory.mkdir();
        }

        String nomeSaida = String.format("%s/%s", nomeDiretorio, nomeArquivo);

        ImageIO.write(novaImagem, "png", new File(nomeSaida));
    }
}
