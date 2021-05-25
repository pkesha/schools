package day02.demoExceptionHandling;

import java.util.ArrayList;

public class DemoIndexOutOfBoundsException {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            arrayList.get(10);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Hello World");
    }
}
