package day05.FinalDemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                '}';
    }
}

public class Demo {
    public static void main(String[] args) {
        List<Person> personList1 = Arrays.asList(
                new Person("Tom", 30),
                new Person("Jeff", 70)
        );


        List<Person> personList2 = Arrays.asList(
                new Person("Jane", 45),
                new Person("Alice", 48),
                new Person("Bob", 38)
        );

        List<List<Person>> listOfPersonList = Arrays.asList(personList1,personList2);

        //Flatmap
        List<Person> flatPersonList = listOfPersonList.stream()
                //Combines both lists
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        flatPersonList.forEach(person -> System.out.println(person));

        //findFirst()
        Person personOverThirtyFive = personList1.stream()
                //Look for person based off of condition
                .filter(person -> person.getAge() > 35)
                //Find the first person
                .findFirst()
                //if not found, return null
                .orElse(null);

        System.out.println(personOverThirtyFive);

        Person[] personArray = personList1.toArray(new Person[personList1.size()]);
        System.out.println(personArray[1]);

        //toMap
//        Map<String, List<Person>> nameToAgeMap = flatPersonList.stream()
//                .collect(
//                        Collectors.toMap(person -> person.getName(), person -> ));
//
//        nameToAgeMap.forEach((k, v) -> System.out.println(k + " " + v));
//        List<String>
    }
}
