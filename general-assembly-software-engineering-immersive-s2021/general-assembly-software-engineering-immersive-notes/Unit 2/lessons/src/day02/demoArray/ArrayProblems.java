package day02.demoArray;

import java.util.Arrays;

public class ArrayProblems {
    public static void main(String[] args) {
        String[] favoriteThings = {"Java", "C++", "Python"};
        String[] favoriteThingsLarge = new String[4];

        //Copy arrays.
        //Copy into favorite things starting at position 0.
        //Copy elements from 0 length of 3 from favoriteThingsLarge
        System.arraycopy(favoriteThings, 0, favoriteThingsLarge, 0, 3);
        favoriteThingsLarge[3] = "ASM";
        System.out.println(Arrays.toString(favoriteThingsLarge));

        int[] primeNumbers = {5, 3, 11, 7, 2};
        int indexOf11 = Arrays.binarySearch(primeNumbers, 11);
        System.out.println(indexOf11);
    }
}
