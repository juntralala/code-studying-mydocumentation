package com.ujun;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] integerArray = {1,2,3,4,5};

        Scanner userInput = new Scanner(System.in);
        FileInputStream newFile = null;
        System.out.print("Nilai array ke : ");
        int index = userInput.nextInt();
//        try {
//            System.out.printf("index ke-%d adalah %d\n", index, integerArray[index]);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//
//        try {
//            newFile = new FileInputStream("file.txt");
//        } catch (Exception e) {
//            System.out.println(e);
//        }

//        try{
//            System.out.printf("index ke-%d adalah %d\n", index, integerArray[index]);
//            newFile = new FileInputStream("file.txt");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.err.println("Array melebihi kapasitas");
//        } catch (IOException e) {
//            System.err.println("File.txt tidak di temukan");
//        } finally {
//            System.out.println("ini adalah Finally");
//
//        }

        try{
            System.out.printf("index ke-%d adalah %d\n", index, integerArray[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array melebihi kapasitas");
        } finally {
            System.out.println("ini adalah Finally");
        }

        System.out.println("akhir dari program");

    }
}
