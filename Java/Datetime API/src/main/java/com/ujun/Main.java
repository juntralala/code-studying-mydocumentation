package com.ujun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ketik namamu: ");
        String name = scanner.next();
        System.out.println("Hello " + name);

    }
}