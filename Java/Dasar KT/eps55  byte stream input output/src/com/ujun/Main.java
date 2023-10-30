package com.ujun;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
/*
        try {
            FileOutputStream newdata = new FileOutputStream("File2.txt");
            FileInputStream file = new FileInputStream("File.txt");

            int buffer = file.read();
            while (buffer != -1) {
                newdata.write(buffer);
                buffer = file.read();
            }
        } finally {
            System.out.println("Byte => %d");
        }

 */
        try (
                FileInputStream data = new FileInputStream("Data.txt");
                FileOutputStream data2 = new FileOutputStream("Data2.txt")
            ) {
            int asciiIndex = data.read();
            while (asciiIndex != -1) {
                System.out.print((char)asciiIndex);
                data2.write(asciiIndex);
                asciiIndex = data.read();
            }
        }
        System.out.println();

    }
}
