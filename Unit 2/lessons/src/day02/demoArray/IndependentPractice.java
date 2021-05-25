package day02.demoArray;

import java.util.ArrayList;

public class IndependentPractice {
    public static void main(String[] args) {
        //Find the size
        int[] ints = {11, 23, 65, 89};
        System.out.println(ints.length);

        //Concrete Jungle
        ArrayList<String> nYC= new ArrayList<>();
        nYC.add("Birbs");
        nYC.add("Cats");
        nYC.add("Dogs");

        for(String string : nYC){
            System.out.println("Today I saw " + string);
        }

        //Sum it up
        int[] sum = new int[3];
        int length = sum.length;
        int total = 0;
        if(length == 0) {
            total = 0;
        } else if(length == 1) {
            total = sum[0];
        } else {
            total = sum[0] + sum[1];
        }

    }

//    public static String pigLatin(ArrayList<String> words) {
//
//    }




}
