import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello there!");
        System.out.println("You are now using Simple Calculator in Java");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            int result = 0;

            System.out.println("1 - Addition");
            System.out.println("2 - Subtraction");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Division");
            System.out.println("9 - Exit");

            int operation = scanner.nextInt();

            if (operation != 9) {
                if (operation > 4) {
                    System.out.println("Invalid input\n");

                    continue;
                }

                System.out.println("Type your first number: ");
                int firstNumber = scanner.nextInt();

                System.out.println("Type your second number: ");
                int secondNumber = scanner.nextInt();

                if (operation == 1) {
                    result = firstNumber + secondNumber;
                } else if (operation == 2) {
                    result = firstNumber - secondNumber;
                } else if (operation == 3) {
                    result = firstNumber * secondNumber;
                } else if (operation == 4) {
                    result = firstNumber / secondNumber;
                }

                System.out.println(result);
                System.out.println();
            } else {
                System.out.println("Calculator turning off...\n");
                running = false;
            }

        }

        scanner.close();
    }
}
