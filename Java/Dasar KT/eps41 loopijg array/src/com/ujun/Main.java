package com.ujun;

public class Main {
    public static void main(String[] args) {

        int[] angka = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0 ; i<10 ; i++) {
            System.out.printf("Index ke %d : %d\n",i,angka[i]);
        }

        for (int i = 0 ; i<angka.length ; i++) {
            System.out.println("Index ke "+ i +" : "+ angka[i]);
        }

        for (int nilai : angka) {
            System.out.println("Nilai Array : "+ nilai);
        }

    }

}
