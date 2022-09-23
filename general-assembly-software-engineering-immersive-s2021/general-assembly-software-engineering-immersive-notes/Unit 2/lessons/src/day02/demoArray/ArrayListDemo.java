package day02.demoArray;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        //Can store many data types
        ArrayList myArrayList = new ArrayList();
        myArrayList.add("Hello");
        myArrayList.add("Hi");
        myArrayList.add(1);
        myArrayList.add(12.3);
        System.out.println(myArrayList.get(1));

        //This can only hold String
        ArrayList<String> myBooks = new ArrayList<>();
        myBooks.add("Java");
        myBooks.add("C++");
        myBooks.add("ASM");
    }

    //This needs to be in Main
//    ArrayList<String> myBooks = new ArrayList<>();
//    myBooks.add("Java");
}
