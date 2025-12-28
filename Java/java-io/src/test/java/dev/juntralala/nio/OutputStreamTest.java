package dev.juntralala.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class OutputStreamTest {

    @Test
    public void output() throws IOException {
        OutputStream out = Files.newOutputStream(Path.of("hello.txt"));
        byte[] bytes = "hello\nucup surucup dari nebula\nlalalaal".getBytes(UTF_8);

        for (byte aByte : bytes) {
            out.write(aByte);
        }

        out.flush();
        out.close();

        System.out.println(out.getClass().getName());

    }
}
