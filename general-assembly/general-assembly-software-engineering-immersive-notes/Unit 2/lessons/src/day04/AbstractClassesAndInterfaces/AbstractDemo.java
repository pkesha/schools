package day04.AbstractClassesAndInterfaces;

abstract class RemoteControl {

}

abstract class Equipment {
    public abstract void showLogo(String logoName);
    public abstract void computePower(double time);

    //We don't have the abstract keyword - complete method don't need implement in child classes
    //Child classes have access
    public void sayHello() {
        System.out.println("Hi from abstract Equipment class");
    }
}




class LEDTelevision extends Equipment {
    private double power;

    public LEDTelevision(String logo, double power) {
        this.showLogo(logo);
        this.power = power;
    }

    public void showLogo(String logoName) {
        System.out.println(logoName);
    }

    public void computePower(double time) {
        double cost = time * power;
        System.out.printf("%.2f\n", cost);
    }
}



class LCDTelevision extends Equipment {
    private double power;

    public LCDTelevision(String logo, double power) {
        this.showLogo(logo);
        this.power = power;
    }

    public void showLogo(String logoName) {
        System.out.println(logoName);
    }

    public void computePower(double time) {
        double cost = 0.3 * time * power;
        System.out.printf("%.2f\n", cost);
    }
}



public class AbstractDemo
{
    public static void main(String[] args) {
        LEDTelevision ledTelevision = new LEDTelevision("Samsung", 50);
        ledTelevision.computePower(12);

        LCDTelevision lcdTelevision = new LCDTelevision("Sony", 75);
        lcdTelevision.computePower(12);

        Equipment equipment = new LCDTelevision("Samsung", 12);
    }
}
