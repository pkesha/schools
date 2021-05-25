package day02.demoExceptionHandling;

public class DemoThrowsKeyword {
    public void testMethod(int[] arr, int x, int y, int z)
            throws ArithmeticException, IndexOutOfBoundsException {
        arr[z] = x / y;
    }

    public static void main(String[] args) {
        DemoThrowsKeyword demoThrowsKeyword1 = new DemoThrowsKeyword();
        demoThrowsKeyword1.testMethod(new int[] {1, 2}, 20, 0, 1);
    }
}
