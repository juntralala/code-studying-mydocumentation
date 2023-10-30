package com.ujun;

public class Main {

    public static void main(String[] args){
        byte angka1 = 5;
        String Angka1Bits = String.format("%8s",Integer.toBinaryString(angka1)).replace(" ","0");
        System.out.printf("%10s bit : %d\n",Angka1Bits,angka1);
    }

}
