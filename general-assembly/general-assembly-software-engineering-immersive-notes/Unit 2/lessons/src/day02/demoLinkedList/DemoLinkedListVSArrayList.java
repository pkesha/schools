package day02.demoLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class DemoLinkedListVSArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hi");
        arrayList.add("Hello");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hi");
        linkedList.add("hello");

        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        for(int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }
        for(int i = 4; i < 15; i++) {
            if (integerLinkedList.get(i) != null) {
                integerLinkedList.remove(i);
            }
        }
    }

}
