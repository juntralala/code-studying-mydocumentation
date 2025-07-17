package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

/** Path
 * Sejak Java 7, dikenalkan class Path yang bisa digunakan untuk mengakses resource sebagai pengganti class File
 * Path adalah sebuah interface, untuk membuat Path, kita bisa gunakan static method Path.of(pathname)
 * Path terdapat di package java.nio.file
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Path.html
 */

// lebih lanjutnya ada di FilesTest

public class PathTest {

    @Test
    public void createPath() {
        Path path = Path.of("file.txt");

        Assertions.assertEquals("file.txt", path.toString());
        Assertions.assertFalse(path.isAbsolute());
    }

}
