package com.ujun;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    char[] namaChar = {'M','u','h','a','m','m','a','d',' ','J','u','n','a','i','d','i'};
    String namaString = "Muhammad Junaidi";
    System.out.println(Arrays.toString(namaChar));
    System.out.println(namaString);

    System.out.println("kompunen ke10 : " + namaChar[9]);
    System.out.println("kompunen ke10 : " + namaString.charAt(9));
    // Merubah Kompunen String
    // namaString.charAt(1) = "A"; => Ini akan error!!
    // meubah kompunen String tidak bisa di lakukan karena String pada Java barsifat Immutable
    namaChar[10] = 'B';
    //Tapi kita bisa meruubah String secara tidak langsung
    String namaBerubah = namaString.substring(0,9) + "B" + namaString.substring(10);
    System.out.println(namaBerubah);

    getAddress("namaString",namaString);
    getAddress("namaBerubah",namaBerubah);

    String nama = "Muhammad Junaidi";
    getAddress("nama",nama);

    System.out.println("<" + "=".repeat(40) + ">\n");
    String nama2 = new String("Muhammad Junaidi");
    System.out.println(namaString == nama2); // yang didini nilainya false karena membandikan address
    System.out.println(namaString.equals(nama2)); // yang didini membandingkan nilai

    }

    static void getAddress(String nama,String data) {
        System.out.println("Address dari " + nama + " : " + Integer.toHexString(System.identityHashCode(data)) + " => " + data);
    }

}
