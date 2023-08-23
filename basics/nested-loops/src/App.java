import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int rows;
        int columns;
        String symbol;

        System.out.println("Enter # of rows: ");
        rows = scanner.nextInt();

        System.out.println("Enter # of columns: ");
        columns = scanner.nextInt();

        System.out.println("Enter symbol of use: ");
        symbol = scanner.next();

        scanner.close();

        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                System.out.printf(symbol);
            }

            System.out.println();
        }
    }
}
