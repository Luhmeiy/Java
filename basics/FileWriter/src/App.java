import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            FileWriter writer = new FileWriter("poem.txt");

            writer.write("Roses are red \nViolets are blue");
            writer.append("\n\n(A poem by Luhmeiy)");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
