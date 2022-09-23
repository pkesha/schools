package day02.demoDebugging;

public class DemoStackTrace {
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println("Hello World");
        int x = 100;
        int y = 0;
        int z = x / 0;
    }
}
