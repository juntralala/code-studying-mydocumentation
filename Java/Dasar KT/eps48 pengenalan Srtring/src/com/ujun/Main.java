package com.ujun;

public class Main {

    public static void main(String[] args) {

        String nama = "Muhammad Junaidi";
        System.out.printf("Nama : %s\n", nama);
        System.out.println(nama.charAt(0));
        getAddress(nama);

    }

    static void getAddress(String data) {
        int address = System.identityHashCode(data);
        System.out.printf("Adress %s : %s",data , Integer.toHexString (address));
    }

}
