package day05.LambdaAndStreams;

public class LambdaExpressionIntroDemo {
    interface Compute {
        int operation(int a, int b);
    }

    public static void main(String[] args) {
        Compute add = (a, b) -> a + b;
    }
}
