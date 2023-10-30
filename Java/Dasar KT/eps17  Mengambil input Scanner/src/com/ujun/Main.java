package com.ujun;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan Nilai Input : ");
        int input = userInput.nextInt();
        System.out.printf("\nKamu memasukkan nilai Input : %d\n<====Menghitung Luas Persegi Panjang====>\n",input);
        System.out.print("Masukkan input Panjang : ");
        int panjang = userInput.nextInt();
        System.out.print("Masukkan input Tinggi : ");
        int tinggi = userInput.nextInt();
        int luas = panjang * tinggi;
        System.out.printf("Luas = %d",luas);

    }
}
