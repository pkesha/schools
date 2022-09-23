package day04.demoSubClasses;

class Animal extends Object {

}

public class Cat {
    private String name;
    private int age;
    private int humanYears;
    private boolean hasWhiskers;
    private int lives;
    private String favoriteFood;

    public String getFavoriteFood() {
        return "Mice";
    }

    public int getLives() {
        return 9;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isHasWhiskers() {
        return hasWhiskers;
    }

    public void setHasWhiskers(boolean hasWhiskers) {
        this.hasWhiskers = hasWhiskers;
    }

    public int getAge() {
        return age;
    }

    public void getAge(int age, int humanYears) {
        this.age = age;
        this.humanYears = humanYears;
    }

    public void getFoo() {
        //return "";
    }

    public void getFoo(int x) {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    //Cannot change when instantiated
    public final int cannotChange() {
        return 1;
    }
}

class Lion extends Cat {
    @Override
    public int getLives() {
        return 1;
    }
}
