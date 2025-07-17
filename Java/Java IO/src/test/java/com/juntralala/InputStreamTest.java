package com.juntralala;


import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/** InputStream
 * InputStream merupakan base Interface yang digunakan untuk membaca Resource
 * InputStream menggunakan numeric data, sehingga jika kita ingin membaca data text, kita harus konversi menjadi data numeric terlebih dahulu
 * Sangat disarankan menggunakan InputStream pada kasus data yang non Text, seperti gambar, video, dan lain-lain
 * Jika data Text, lebih disarankan menggunakan Reader karena bisa langsung menggunakan tipe data Character
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/InputStream.html
 */

public class InputStreamTest {

    @Test
    public void inputStream() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            while ((data = inputStream.read()) != -1) {
                builder.append((char) (data));
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void inputStreamReadBytes() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] buffer = new byte[256];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, length));
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
