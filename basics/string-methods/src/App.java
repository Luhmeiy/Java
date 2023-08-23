public class App {
    public static void main(String[] args) throws Exception {
        String name = " Luiz";

        System.out.println(name.equals("luiz"));
        System.out.println(name.equalsIgnoreCase("luiz"));

        System.out.println(name.length());

        System.out.println(name.charAt(2));
        System.out.println(name.indexOf("i"));

        System.out.println(name.isEmpty());

        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        System.out.println(name.trim());

        System.out.println(name.replace("z", "s"));
    }
}
