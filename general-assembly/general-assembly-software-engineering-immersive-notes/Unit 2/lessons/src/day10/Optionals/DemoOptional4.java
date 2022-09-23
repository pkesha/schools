package day10.Optionals;

import java.util.Optional;

class Person {
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class DemoOptional4 {
    public static void main(String[] args) {
        Person person = new Person(null);
        boolean canBuy = Optional.ofNullable(person)
                .map(Person::getAge)
                .filter(age -> age >= 23)
                .isPresent();

        System.out.println(canBuy);
    }
}
