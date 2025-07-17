package com.ujun;

public class Main {
    public static void main(String[] args){
        int angka1 = 12;
        String angka1Bits = String.format("%8S",Integer.toBinaryString(angka1)).replace(" ","0");
        int angka2 = 6;
        String angka2Bits = String.format("%8s",Integer.toBinaryString(angka2)).replace(" ","0");
        int angka3 = angka1 & angka2;
        String angka3Bits = String.format("%8s",Integer.toBinaryString(angka3)).replace(" ","0");
        System.out.println("Binary angka1 : "+angka1Bits);
        System.out.println("Binary angka2 : "+angka2Bits);
        System.out.println("Binary angka2 : "+angka3Bits);
    }
}
