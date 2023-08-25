public class App {
    public static void main(String[] args) throws Exception {
        hello("Luiz");

        int z = add(5, 2);
        System.out.println(z);
    }

    static void hello(String name) {
        System.out.println("Hello " + name);
    }

    static int add(int x, int y) {
        int z = x + y;

        return z;
    }
}
