package day02.demoExceptionHandling;

public class DemoCatchingMultipleExceptions {
    public static void main(String[] args) {
        try {
            int arr[] = new int[7];
            arr[4] = 30/10;
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        } finally {
            System.out.println("Will Run no matter what");
            System.out.println("System cleaning and logging occurs in the block");
        }

        System.out.println("Some other code");

    }
}
