public class App {
    public static void main(String[] args) throws Exception {
        MyGenericClass<Integer, Integer> myInt = new MyGenericClass<>(1, 9);
        MyGenericClass<Double, Double> myDouble = new MyGenericClass<>(3.14, 1.01);
        // MyGenericClass<Character, Character> myCharacter = new MyGenericClass<>("@",
        // "$");
        // MyGenericClass<String, Character> myString = new MyGenericClass<>("Hello",
        // "!");

        System.out.println(myInt.getX());
        System.out.println(myDouble.getY());
    }
}
