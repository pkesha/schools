package day04.demoSubClasses;

public class CatDemo {


    //Overloading example, because we have the same name for the method but different
    //parameters
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("This is a cat");
        System.out.println(cat);
    }
}
