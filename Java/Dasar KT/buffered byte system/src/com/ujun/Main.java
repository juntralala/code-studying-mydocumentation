package com.ujun;

import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {

        long waktuStart,waktuEnd;
        

        // membaca dari file
        FileInputStream byteInput = new FileInputStream("FileInput.txt");
        System.out.println(byteInput.available());

        // menghitung waktu pembacaan
        waktuStart = System.nanoTime();

        System.out.println(byteInput.readAllBytes());

        waktuEnd = System.nanoTime();
        System.out.println("Waktu : " + (waktuEnd-waktuStart));
        byteInput.close();

        // membaca dari memori
        FileInputStream byteInput2 = new FileInputStream("FileInput.txt");
        BufferedInputStream bufferedInput = new BufferedInputStream(byteInput2);

        bufferedInput.mark(20000);

        waktuStart = System.nanoTime();
        System.out.println(bufferedInput.readAllBytes());
        waktuEnd = System.nanoTime();
        System.out.println("Waktu : " + (waktuEnd-waktuStart));

        bufferedInput.reset();
        byte[] data = bufferedInput.readAllBytes();
        String dataString = new String(data);
        System.out.println(dataString);

        FileOutputStream byteOutput = new FileOutputStream("output.txt");
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(byteOutput);

        // write data berupa byte
        bufferedOutput.write(data,0,data.length);
        bufferedOutput.flush();
        byteInput2.close();
        byteOutput.close();
        bufferedInput.close();
        bufferedOutput.close();

    }
}
