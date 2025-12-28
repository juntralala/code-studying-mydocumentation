package dev.juntralala.nio;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class InputStreamTest {

    @Test
    public void readBytes() throws IOException {
        var stream = Files.newInputStream(Path.of("hello.txt"));
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
