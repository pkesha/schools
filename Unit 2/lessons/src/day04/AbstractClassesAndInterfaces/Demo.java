package day04.AbstractClassesAndInterfaces;

class Person{
}

interface SmartPhone{
}

class MobilePhone implements SmartPhone{ // IS A
}

class Student extends Person{ // IS A
    MobilePhone mobilePhone; // HAS A
}

public class Demo {
}
