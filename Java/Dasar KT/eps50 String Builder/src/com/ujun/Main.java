package com.ujun;

import java.lang.StringBuilder;

public class Main {
    public static void main (String[] args) {

    StringBuilder namaStringBuilder = new StringBuilder("Muhammad Junaidi");
    printStringBuilder(namaStringBuilder);

    namaStringBuilder.append(" yang pintar");
    printStringBuilder(namaStringBuilder);

    namaStringBuilder.append(" lagi berbakti kepada orang tua");
    printStringBuilder(namaStringBuilder);

    namaStringBuilder.insert(0,"Saya ");
    printStringBuilder(namaStringBuilder);

    namaStringBuilder.delete(21,64);
    printStringBuilder(namaStringBuilder);

    namaStringBuilder.setCharAt(14,'B');
    printStringBuilder(namaStringBuilder);

    namaStringBuilder.replace(0,4,"Muhammad Junaidi dan");
    printStringBuilder(namaStringBuilder);

    String namaString = namaStringBuilder.toString();
    System.out.println("namaString         : " + namaString);
    System.out.println("namaString Address : " + Integer.toHexString(namaString.hashCode()));

    }

    private static void printStringBuilder(StringBuilder data) {

        System.out.println("Data      : " + data);
        System.out.println("Panjang   : " + data.length());
        System.out.println("Kapasitas : " + data.capacity());
        System.out.println("Address   : " + Integer.toHexString(data.hashCode()) + "\n");

    }

}
