package com.ujun;

public class Main {

    public static void main (String[] args){
        // unary '+' dan '-'
        int angka1 = 5;
        System.out.printf("Unary '+' : %d\n", +angka1);
        System.out.println("Unary '-' : " + -angka1);
        // unary Inscrement dan Decrement
        int angka2 = 10;
        System.out.println("Incement prefix : "+ ++angka2);
        int angka3 = 10;
        System.out.println("Increment postfix : "+ angka3++);
        System.out.println("Increment postfix : "+ angka3);
        System.out.println("Decrement Prefix : "+ --angka1);
        // Unary ! untuk boolean
        boolean madan = true;
        System.out.println("Tanpa Unari '!' : "+ madan);
        System.out.println("Unari Bang '!'  : "+ !madan);
    }
}
