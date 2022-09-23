package day02.demoLinkedList;

import java.util.HashMap;
import java.util.Map;

class Student {
    public String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class demoMaps {
    public static void main(String[] args) {
        //Key will be string and value will be Student data type.
        HashMap<String, Student> studentHashMap = new HashMap<String, Student>();
        Student studentA = new Student();
        Student studentB = new Student();
        Student studentC = new Student();

        studentA.setName("John");
        studentB.setName("Sam");
        studentC.setName("Sharon");

        studentHashMap.put("1", studentA);
        studentHashMap.put("2", studentB);
        studentHashMap.put("3", studentC);

        System.out.println(studentHashMap);

        //for every entry in the map object, select the entry sets
        for(Map.Entry<String, Student> entry : studentHashMap.entrySet()) {
            //Gets the key and the object.
            //entry gets key (String) and value (Student object)
            //entry.getValue() -> return object in memory.
            System.out.println(entry.getKey() + " " + entry.getValue().getName());
        }


    }
}
