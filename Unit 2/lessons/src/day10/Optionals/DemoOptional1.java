package day10.Optionals;

import java.util.Optional;

public class DemoOptional1 {
    public static void main(String[] args) {
        //Empty container of only type String
        Optional<String> emptyOptional = Optional.empty();
        //Will return true of false
        System.out.println(emptyOptional.isPresent());


        String name = "Parham";
        Optional<String> stringOptional1 = Optional.of(name);
        System.out.println(stringOptional1.isPresent());

        String stringValue  = null;
        Optional<String> optionalValue = Optional.ofNullable(stringValue);
        System.out.println(optionalValue);

        Integer age = 22;
        Optional<Integer> ageOptional = Optional.ofNullable(age);
        ageOptional.ifPresent(myAge -> System.out.println("My age is " + age));
    }
}
