package com.juntralala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Manipulasi Directory
 * Directory atau Folder juga bisa dimanipulasi menggunakan class Files
 */

/**
 | Method                                | Keterangan                               |
 |---------------------------------------|------------------------------------------|
 | Files.createDirectories(path)         | Membuat banyak directory jika tidak ada  |
 | Files.createDirectory(path)           | Membuat satu directory                   |
 | Files.newDirectoryStream(path)        | Membaca semua isi file di directory      |
 | Files.isDirectory(path)               | Mengecek apakah path sebuah directory    |
 */

public class ManipulasiDirectoryTest {

    @Test
    public void directoryManipulation() throws IOException {
        Path path = Path.of("contoh");
        Files.createDirectory(path);

        Assertions.assertTrue(Files.isDirectory(path));
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }

}