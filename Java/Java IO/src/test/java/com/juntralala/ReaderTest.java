package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

/** Reader
 * Reader adalah Input Stream untuk membaca resource berupa text
 * Dengan menggunakan Reader, kita bisa melakukan konversi otomatis dari numeric data menjadi character data
 * Untuk membaca data per character, kita bisa menggunakan method read()
 * Sedangkan untuk membaca langsung beberapa character, kita bisa gunakan method read(char[])
 * Cara penggunaannya mirip dengan InputStream
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Reader.html
 */

public class ReaderTest {

    @Test
    public void reader() {
        var path = Path.of("pom.xml");
        try (Reader reader = Files.newBufferedReader(path)) {
            int data;
            StringBuilder builder = new StringBuilder();
            while ((data = reader.read()) != -1) {
                builder.append((char) data);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void readerChars() {
        var path = Path.of("pom.xml");
        try (Reader reader = Files.newBufferedReader(path)) {
            char[] data = new char[256];
            StringBuilder builder = new StringBuilder();
            while (reader.read(data) != -1) {
                builder.append(data);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
