import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) throws Exception {
        double x;
        double y;
        double z;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter side x: ");
        x = scanner.nextDouble();

        System.out.println("Enter side y: ");
        y = scanner.nextDouble();

        scanner.close();

        z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("The hypotenuse is " + z);
    }
}
