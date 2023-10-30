package com.ujun;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
        FileInputStream file = new FileInputStream("data.txt");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
