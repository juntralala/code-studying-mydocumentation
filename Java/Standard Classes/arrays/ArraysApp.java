package arrays;

import java.util.Arrays;

/**
 * Arrays calss adlah class yang bersikan stati methodyang bisa kita gunakan untukmemanipulasi data array, seperti
 * pencarian dan perurutan
 */

public class ArraysApp {
    public static void main(String[] args) {

        int[] numbers = {4,8,1,0,5,8,3,7,9,4,9,2,4,1,8,5,6};

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers, 7));  // returnnya index
        System.out.println( numbers[Arrays.binarySearch(numbers, 7)] );

        int[] cp = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(cp));

        int[] cpr = Arrays.copyOfRange(numbers, 4, 8);
        System.out.println(Arrays.toString(cpr));

    }
}
