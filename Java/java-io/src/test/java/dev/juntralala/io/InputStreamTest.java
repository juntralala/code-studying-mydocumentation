package dev.juntralala.io;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// input stream sebelum java nio

public class InputStreamTest {

    @Test
    public void readBytes() throws IOException {
        InputStream stream = new FileInputStream("hello.txt");
        byte[] buffer = new byte[127];
        StringBuilder builder = new StringBuilder();

        int a;
        while (true) {
            a = stream.read(buffer);
            if (a <= 0) {
                break;
            }
            for (byte i = 0; i < a; i++) {
                builder.append((char) buffer[i]);
            }
        }
        System.out.println(builder);

        stream.close();
    }
}
