package com.juntralala;


/** Manipulasi File
 * Seperti yang dijelaskan di awal, membuat File atau Path bukan berarti file otomatis terbuat, itu hanya object di Java, bukan representasi nyata di File System
 * Namun dengan menggunakan class Files, kita bisa melakukan manipulasi file seperti membuat, menghapus atau membacanya
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * | Method                                         | Keterangan                            |
 * |------------------------------------------------|---------------------------------------|
 * | Files.createFile(path)                         | Membuat file                          |
 * | Files.delete(path) / Files.deleteIfExists(path)| Menghapus file / jika ada             |
 * | Files.copy(source, target)                     | Menyalin file                         |
 * | Files.move(source, target)                     | Memindahkan file                      |
 */

public class ManipulasiFileTest {

    @Test
    public void fileManipulation() throws IOException {
        Path path = Path.of("files.txt");

        Files.createFile(path);
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }
}
