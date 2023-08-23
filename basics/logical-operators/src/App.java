import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are playing a game! Press q or Q to quit");
        String response = scanner.next();

        scanner.close();

        if (!response.equals("q") && !response.equals("Q")) {
            System.out.println("You are still playing the game");
        } else {
            System.out.println("You quit the game");
        }
    }
}
