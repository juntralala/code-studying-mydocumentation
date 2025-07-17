package com.ujun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner userInput;
        float a,b,hasil;
        char operator;

        //Input
        userInput = new Scanner(System.in);
        System.out.print("Masukkan Nilai a : ");
        a = userInput.nextFloat();
        System.out.print("Masukan Operator : ");
        operator = userInput.next().charAt(0);
        System.out.print("Masukkan Nilai b : ");
        b = userInput.nextFloat();

        //proses
        hasil = operator=='+' ? a+b : (operator=='-')? a-b:(operator=='*')? a*b: (operator=='/')? (b!=0)? a/b: 0 : (operator=='%')? a%b: 0 ;
        System.out.println("Hasil " + operator +" : "+ hasil);


    }
}
