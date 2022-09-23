package day02.demoArray;

public class DemoArray {
    public static void main(String[] args) {
        int[] myArray;
        myArray = new int[10];
        //Shows element at index
        System.out.println(myArray[10]);
        //Shows memory beginning of the array
        System.out.println(myArray);

        String[] stringsFav = new String[3];
        stringsFav[0] = "God";
        stringsFav[1] = "family";
        stringsFav[2] = "pets";

        //Both are the same
        for(int i = 0; i < stringsFav.length; i++) {
            System.out.println(stringsFav[i]);
        }

        for(String index: stringsFav) {
            System.out.println(index);
        }
    }
}
