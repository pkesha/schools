package day05.LambdaAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoLambda2 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("My name is", "My friend call me ","My Mom call me ");
        List<String>stringList1 = new ArrayList<>();

        stringList1.forEach(stringValue -> stringList1.add(stringValue + "Parham"));
    }
}
