package dev.juntralala.nio;

import org.junit.jupiter.api.Test;
import java.io.Reader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class ReaderTest {

    @Test
    public void reader() throws IOException {
        Reader reader = Files.newBufferedReader(Path.of("writer.txt"));
        var stringBuilder = new StringBuilder();

        int singleChar; // yg dibaca char(16bit unsigned) tapi return nya int
        while ((singleChar = reader.read()) != -1) {
            stringBuilder.append((char) singleChar);
        }

        System.out.println(stringBuilder);
        reader.close();
    }
}
