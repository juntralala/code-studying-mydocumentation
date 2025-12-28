package dev.juntralala.io;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderTest {

    @Test
    public void reader() throws IOException {
        Reader reader = new FileReader("writer.txt");
        var stringBuilder = new StringBuilder();

        int singleChar; // yg dibaca char(16bit unsigned) tapi return nya int
        while ((singleChar = reader.read()) != -1) {
            stringBuilder.append((char) singleChar);
        }

        System.out.println(stringBuilder);
        reader.close();
    }
}
