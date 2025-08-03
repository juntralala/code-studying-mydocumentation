package com.ujun;

import java.util.Arrays;

public class Main {
    public  static void main(String[] args) {
        int[] array1 = {1,2,3,8,4,5,6,3,5,7,9,8};
        int[] array2 = {0,7,9,6,3,5,7,9,7,5,4,90};
        print("Array1 : ",array1);
        print("Array2 : ",array2);

        int[] hasilTambahArray = penjumlahanArray(array1,array2);
        print("Penjumlahan array : ",hasilTambahArray);

        int[] sortedArray1 = Arrays.copyOf(array1,array1.length);
        Arrays.sort(sortedArray1);
        print("sorted array1 : ",sortedArray1);
        Arrays.sort(array2);
        print("sorted array2 : ",array2);

        sortReverse1(array1);
        sortReverse2(array2);
        print("array1 sort reverse1 : ",array1);
        print("array2 sort reverse2 : ",array2);

    }

    public static void print(String massage, int[] dataArray) {
        System.out.println(massage + Arrays.toString(dataArray));
    }

    private static void sortReverse1(int[] dataArray) {
        Arrays.sort(dataArray);
        int[] bufferArray = Arrays.copyOf(dataArray,dataArray.length);
        for (int i = 0 ; i < dataArray.length ; i++) {
            dataArray[i] = bufferArray[dataArray.length-i-1];
        }
    }

    private static void sortReverse2 (int[] dataArray) {
        int buffer;
        Arrays.sort(dataArray);
        for (int i=0 ; i<dataArray.length/2; i++) {
            buffer = dataArray[i];
            dataArray[i] = dataArray[dataArray.length-i-1];
            dataArray[dataArray.length-i-1] = buffer;
        }
    }

    private static int[] penjumlahanArray(int[] dataArray1,int[] dataArray2) {
        int[] hasil = new int[dataArray1.length];
        for (int i=0 ; i<dataArray1.length ; i++) {
            hasil[i] = dataArray1[i]+dataArray2[i];
        }
        return hasil;
    }

}
