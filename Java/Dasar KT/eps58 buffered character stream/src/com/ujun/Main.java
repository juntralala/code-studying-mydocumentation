package com.ujun;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        // Membaca file dulu
        FileReader fileInput = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileInput);
        bufferedReader.mark(1000);

        // membaca kedalam string
        String data = bufferedReader.readLine();
        System.out.println(data);

        // Membaca kedalam Char
        bufferedReader.reset();
        char[] dataChar = new char[21];
        bufferedReader.read(dataChar,0,21);

        System.out.println(Arrays.toString(dataChar));

        // membaca baris
        bufferedReader.reset();
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());

        // menulis file
        bufferedReader.reset();
        FileWriter fileOutput = new FileWriter("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileOutput);

        String baris1 = bufferedReader.readLine();
        String baris2 = bufferedReader.readLine();

        bufferedWriter.write(baris1,0,baris1.length());
        bufferedWriter.flush();

        bufferedWriter.newLine();

        bufferedWriter.write(baris2,0,baris2.length());
        bufferedWriter.flush();

        fileInput.close();
        fileOutput.close();
        bufferedWriter.close();
        bufferedReader.close();


    }
}
