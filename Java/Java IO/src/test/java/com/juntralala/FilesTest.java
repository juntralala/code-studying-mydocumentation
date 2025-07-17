package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

/** Files
 * Path tidak memiliki banyak sekali method seperti di class File
 * Namun terdapat class Files yang bisa digunakan untuk mendapatkan informasi dari Path
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Files.html
 */

// class File beda dengan Files
// ini lanjutan dari Path

public class FilesTest {

    @Test
    public void usingFiles() {
        Path path = Path.of("file.txt");

        Assertions.assertEquals("file.txt", path.toString());
        Assertions.assertFalse(path.isAbsolute());
        Assertions.assertTrue(Files.exists(path));
    }

}
