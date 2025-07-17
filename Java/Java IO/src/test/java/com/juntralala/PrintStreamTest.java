package com.juntralala;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

/** PrintStream
 * Salah satu turunan dari Output Stream yang sering kita gunakan secara tidak sadar adalah Print Stream
 * Print Stream adalah Output Stream yang bisa menerima berbagai jenis data, dan secara otomatis melakukan konversi
   ke numeric data yang dibutuhkan oleh Output Stream
 * Saat kita menggunakan System.out, itu sebenarnya adalah object dari Print Stream
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/PrintStream.html
 */

public class PrintStreamTest {

    @Test
    @DisplayName("print stream to Console")
    public void printStream() {
        PrintStream stream = System.out;

        stream.println("Hello world");
        stream.println("Hello world");
        stream.println("Hello world");
    }

    @Test
    @DisplayName("print stream to File")
    public void printStreamFile() throws IOException {
        Path path = Path.of("print.txt");
        OutputStream outputStream = Files.newOutputStream(path);
        PrintStream stream = new PrintStream(outputStream);

        stream.println("Hello world");
        stream.println("Hello world");
        stream.println("Hello world");
    }

}
