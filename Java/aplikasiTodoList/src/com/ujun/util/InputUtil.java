package com.ujun.util;

public class InputUtil {
    public static String input(String info) {
        System.out.print(info + " : ");
        return new java.util.Scanner(System.in).nextLine();
    }
}
