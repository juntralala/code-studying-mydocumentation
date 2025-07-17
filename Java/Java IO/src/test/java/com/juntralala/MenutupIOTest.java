package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/** Closeable Interface
 * Semua IO Stream di Java adalah turunan dari interface java.io.Closable, dimana terdapat method close() untuk menutup
   Resource yang sudah dibuka.
 * Hal ini agar tidak terjadi memory leak (kondisi dimana kita lupa menutup IO Stream sehingga data tidak bisa dihapus
   di memory oleh Java Garbage Collector)
 */

public class MenutupIOTest {

    @Test
    public void closeIOManual(){
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(path);
            // do something with inputStream
        } catch (IOException e) {
            Assertions.fail(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Assertions.fail(e);
                }
            }
        }
    }

    @Test
    public void closeIOTryWithResource() {
        Path path = Path.of("pom.xml");

        try (InputStream inputStream = Files.newInputStream(path)) {
            // do something with inputStream
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
