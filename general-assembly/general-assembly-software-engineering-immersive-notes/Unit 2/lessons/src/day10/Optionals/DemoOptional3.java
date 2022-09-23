package day10.Optionals;

import java.util.Optional;

public class DemoOptional3 {
    public static void main(String[] args) {
        //Not getting error message - this will use method someDefualtMessage
        //with .orElse method
        Integer userName = (Integer) Optional.ofNullable(10)
                .orElse(someDefaultMessage());
        System.out.println(userName);

        Optional<Integer> ageOptional = Optional.ofNullable(null);
        boolean canBuyAlcohol = ageOptional.filter((age) -> age >= 21).isPresent();
        System.out.println(canBuyAlcohol);
    }

    public static Integer someDefaultMessage() {
        return 0;
    }


}
