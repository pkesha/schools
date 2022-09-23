package day04.AbstractClassesAndInterfaces;

interface Automobile {
    //Methods are abstract by default
    int getYear();
    String getMake();
    String getModel();
    void StartEngine();
}

interface TowVehicle {
    int getCarryingCapacity();
    int getTowingCapacity();
    String getFuelType();
}


public class InterfaceDemo implements Automobile, TowVehicle {

    @Override
    public int getCarryingCapacity() {
        return 4;
    }

    @Override
    public int getTowingCapacity() {
        return 1000000;
    }

    @Override
    public String getFuelType() {
        return "Diesel";
    }

    @Override
    public int getYear() {
        return 2019;
    }

    @Override
    public String getMake() {
        return "Dodge";
    }

    @Override
    public String getModel() {
        return "Ram";
    }

    @Override
    public void StartEngine() {
        System.out.println("vroom vroom");
    }

    public static void main(String[] args) {
        InterfaceDemo interfaceDemo = new InterfaceDemo();
        System.out.println(interfaceDemo.getMake());
        System.out.println(interfaceDemo.getModel());
        System.out.println(interfaceDemo.getYear());

    }
}
