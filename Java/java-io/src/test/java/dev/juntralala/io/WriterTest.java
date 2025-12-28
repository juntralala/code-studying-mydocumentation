package dev.juntralala.io;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

// Reader and Writer are interface that for work with text (for writing)

public class WriterTest {

    @Test
    public void writer() throws IOException {
        Writer writer = new FileWriter("writer.txt");
        writer.write("hello world\n");
        writer.write("hello there");
        writer.close();
    }

    @Test
    public void writerWithAppend() throws IOException { // append  just for chaining methods
        Writer writer = Files.newBufferedWriter(Path.of("writer.txt"));
        writer.append("hello world\n")
                .append("hello there\n")
                .append("another chaining method");
        writer.close();
    }
}
