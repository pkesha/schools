package day10.Optionals;

import java.util.Optional;

class Employee {
    private Optional<Integer> age;

    public Employee(Integer age) {
        this.age = Optional.ofNullable(age);
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }
}

public class OptionalDemo5 {
    public static void main(String[] args) {
        Employee employee = new Employee(null);
        boolean canBuy = Optional.ofNullable(employee)
                .flatMap(Employee::getAge)
                .filter(age -> age >= 21)
                .isPresent();


    }
}
