package day2;

public class Methods {
    public static void main(String[] args) {
        sayHello("Ajlal");

        sayHello("Manas");

        // 10 lines
        sayHello("Anas");
        sayHello("Wamiq");
        System.out.println("Add: " + add(10,20));
    }

    private static void sayHello(String name) {
        System.out.println("Hello, " + name);
        System.out.println("Welcome to Skywards");
    }

    private static int add (int a, int b) {
        return a + b;
    }
}
