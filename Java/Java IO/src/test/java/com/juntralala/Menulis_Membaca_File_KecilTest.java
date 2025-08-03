package com.juntralala;


/**
 * Menulis File Kecil
 * Pada kasus jika kita ingin menulis file dengan ukuran kecil, kita bisa menggunakan class Files
 * Terdapat banyak method yang bisa kita gunakan pada kasus sederhana untuk membuat file dengan ukuran kecil
 * Files.write(path, bytes) untuk menulis file dengan data bytes[]
 * Files.writeString(path, string) untuk menulis file dengan data String
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Membaca File Kecil
 * Pada kasus jika kita ingin membaca file dengan ukuran kecil, kita bisa menggunakan class Files
 * Terdapat banyak method yang bisa kita gunakan pada kasus sederhana untuk membaca file dengan ukuran kecil
 * Files.readAllBytes(path) untuk membaca file menjadi data bytes[]
 * Files.readString(path) untuk membaca file menjadi data String
 * Jangan membaca file ukuran besar dengan cara ini, karena akan menjadikan seluruh data di simpan di memory, yang bisa menyebabkan error OutOfMemory
 */

public class Menulis_Membaca_File_KecilTest {

    @Test
    @Order(1)
    public void writeSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        String data = "Hello dari java io";
        byte[] dataBytes = data.getBytes();
        Files.write(path1, dataBytes);

        Path path2 = Path.of("small2.txt");
        Files.writeString(path2, "Hello IO String");
    }

    @Test
    @Order(2)
    public void readSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        byte[] dataBytes = Files.readAllBytes(path1);
        String data = new String(dataBytes);

        Assertions.assertTrue(Files.exists(path1));
        Assertions.assertEquals("Hello dari java io", data);

        Path path2 = Path.of("small2.txt");
        String dataString = Files.readString(path2);
        Assertions.assertEquals("Hello IO String", dataString);
    }

}
