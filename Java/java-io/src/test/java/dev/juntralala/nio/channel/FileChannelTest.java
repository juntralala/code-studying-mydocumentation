package dev.juntralala.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

import static java.lang.System.out;

public class FileChannelTest {

    @Test
    public void fileChannel() throws IOException {
        FileChannel channel = FileChannel.open(Path.of("hello.txt"));
        ByteBuffer buffer = ByteBuffer.allocate(8);
        StringBuilder builder = new StringBuilder();

        int readed;
        while ((readed = channel.read(buffer)) != -1) {
            out.println("readed= " + readed);
            buffer.flip();
            while (buffer.hasRemaining()) {
                builder.append((char) buffer.get());
            }
            buffer.clear();
        }

        out.println(builder);
        channel.close();
    }
}
