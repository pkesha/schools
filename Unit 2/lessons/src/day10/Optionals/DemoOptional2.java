package day10.Optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemoOptional2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("James");
        names.add("Marc");
        names.add("Jack");

        //Use .of because we might have a value or might not
        Optional<List> optionalList = Optional.of(names);
        System.out.println(optionalList.isPresent());
        System.out.println(optionalList.get());
        System.out.println(optionalList.get().contains("Suresh"));
        System.out.println(optionalList.get().remove(11));
    }
}
