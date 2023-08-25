public class App {
    public static void main(String[] args) throws Exception {
        boolean myBoolean = true;
        char myChar = '#';
        String myString = "Luiz";
        int myInt = 50;
        double myDouble = 1000;

        // System.out.printf("%b", myBoolean);
        // System.out.printf("%c", myChar);
        // System.out.printf("%s", myString);
        // System.out.printf("%d", myInt);
        // System.out.printf("%f", myDouble);

        // [width]
        System.out.printf("Hello %10s", myString);

        // [precision]
        System.out.printf("You have this much money %.1f", myDouble);
    }
}
