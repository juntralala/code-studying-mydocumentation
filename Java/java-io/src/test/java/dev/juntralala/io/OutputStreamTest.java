package dev.juntralala.io;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

// outputstream sbeleum ada nio

public class OutputStreamTest {

    @Test
    public void output() throws IOException {
        OutputStream out = new FileOutputStream("hello.txt");
        byte[] bytes = "hello\nucup surucup dari nebula\nlalalaal".getBytes(UTF_8);

        for (byte aByte : bytes) {
            out.write(aByte);
        }

        out.flush();
        out.close();
    }
}
