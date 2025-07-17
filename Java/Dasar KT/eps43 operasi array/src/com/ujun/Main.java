package com.ujun;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int[] angka = {1,2,3,4,5,6,7,8};
        System.out.println(angka);
        System.out.println(Arrays.toString(angka));

        int[] angka1 = Arrays.copyOf(angka,angka.length);
        System.out.println(angka1);
        System.out.println(Arrays.toString(angka1));

        int[] angka2 = angka.clone();
        System.out.println(angka2);
        System.out.println(Arrays.toString(angka2));
    }
}
