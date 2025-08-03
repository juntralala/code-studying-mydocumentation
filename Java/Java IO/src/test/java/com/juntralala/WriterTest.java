package com.juntralala;


/** Writer
 * Writer merupakan base Interface yang digunakan untuk menulis ke Resource untuk data text
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Writer.html
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/** Menulis Data
 * Untuk menulis data di Writer, kita bisa gunakan method dengan awalan write()
 * Kita bisa mengirim data dalam bentuk char int, char[] atau String pada method write()
 */

/*
Files.newBufferedWriter() menggunakan buffer, maka data akan disimpan hanya ketika buffer penuh atau method close dipanggil
Dan direkomendasikan memanggil flush() untuk waktu tertentu jika ingin menghindari data hilang ditengah proses jika terjadi
crush atau kode berhenti
 */

public class WriterTest {

    @Test
    public void writer() {
        Path path = Path.of("writer.txt");
        try (Writer writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 100; i++) {
                writer.write("Hello from writer!\n");
                writer.flush();
                Thread.sleep(1);
            }
        } catch (IOException | InterruptedException e) {
            Assertions.fail(e);
        }
    }

}
