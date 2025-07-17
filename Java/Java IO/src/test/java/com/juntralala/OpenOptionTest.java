package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/** OpenOption
 * Saat kita membuat IO Stream menggunakan class Files, terdapat parameter diakhirnya yaitu OpenOption
 * OpenOption merupakan opsi tambahan yang ingin kita lakukan pada proses IO Stream
 * OpenOption merupakan sebuah interface, implementasinya kita bisa menggunakan enum StandardOpenOption
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/OpenOption.html
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/StandardOpenOption.html
 */

public class OpenOptionTest {

    @Test
    public void appendWithOpenOption() {
        Path path = Path.of("writer.txt");
        try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            for (int i = 0; i < 100; i++) {
                writer.write("Hello from writer!\n");
                writer.flush();
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            Assertions.fail(e);
        }
    }

}
