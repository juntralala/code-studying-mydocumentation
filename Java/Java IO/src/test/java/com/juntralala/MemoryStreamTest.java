package com.juntralala;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;

/** MemoryStream
 * Kadang ada kasus kita ingin membuat IO Stream, namun target resource nya tidak di file, misal hanya di variable dimemory
 * Pada kasus seperti itu, kita bisa memanfaatkan Memory Stream yang tersedia di Java
 */

/** Contoh Memory Stream
 * ByteArrayInputStream, turunan InputStream yang mengambil datanya dari byte[]
 * ByteArrayOutputStream, turunan OutputStream yang menyimpan datanya di byte[] di memory
 * StringReader, turunan Reader yang mengambil data dari String
 * StringWriter, turunan Writer yang menyimpan data di String di memory
 */

public class MemoryStreamTest {

    @Test
    public void memoryStream() {
        StringWriter writer = new StringWriter();
        for (int i = 0; i < 10; i++) {
            writer.write("Hello World\n");
        }

        String content = writer.getBuffer().toString();
        System.out.println(content);
    }

}
