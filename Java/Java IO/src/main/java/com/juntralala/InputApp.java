package com.juntralala;

import java.io.InputStream;
import java.util.Scanner;

public class InputApp {
    public static void main(String[] args) {
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);

        System.out.print("Nama mu: ");
        String nama = scanner.nextLine();
        System.out.println(nama);
    }
}
