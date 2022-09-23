package day05.IndependentPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = createPersonList();
        List<Person> personListM;
        List<String> personListString;
        List<Person> personList3;

        // TODO: Create a list of Person objects whose names start with the letter "M".
        personListM = personList.stream()
                .filter(person -> person.getName().charAt(0) == 'M')
                .collect(Collectors.toList());
        System.out.println(personListM);

        // TODO: Create a list of Strings containing the names of persons over the age of 40.
        personListString = personList.stream()
                .filter(person -> person.getAge() > 40)
                .map(person -> person.toString())
                .collect(Collectors.toList());
        System.out.println(personListString);

        // TODO: Create a list of Person objects whose names start with the letter "J" and are under the age of 47.
        personList3 = personList.stream()
                .filter(person -> (person.getName().charAt(0) == 'J') && (person.getAge() < 47))
                .collect(Collectors.toList());
        System.out.println(personList3);
    }

    private static List<Person> createPersonList() {

        return Arrays.asList(
                new Person("Mark", 45),
                new Person("Henry", 30),
                new Person("John", 18),
                new Person("Morgan", 6),
                new Person("Amanda", 23),
                new Person("Tiffany", 60),
                new Person("Jim", 50),
                new Person("Janet", 45)
        );
    }
}
