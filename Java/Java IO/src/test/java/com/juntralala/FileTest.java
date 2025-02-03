package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * File
 * File adalah cara lama mengakses file, walaupun sekarang direkomendasikan menggunakan Path, namun masih banyak yang menggunakan File
 * File direpresentasikan oleh class File
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html
 */

public class FileTest {

    @Test
    public void createFile() {
        File file = new File("file.txt"); // <- hanya membuat file representation

        Assertions.assertEquals("file.txt", file.getName());
        Assertions.assertTrue(file.exists());
    }

}
