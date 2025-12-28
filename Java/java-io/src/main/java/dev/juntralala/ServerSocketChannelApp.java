package dev.juntralala;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ServerSocketChannelApp { // contoh async tanpa Selector
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost", 8080));
        server.configureBlocking(false);

        while (true) {
            SocketChannel socket = server.accept();
            if (socket == null) { // ulangi disini sampe ada yang terkoneksi
                continue;
            }

            var stringBuilder = new StringBuilder();
            var buffer = ByteBuffer.allocate(8);
            int byteCount;
            while ((byteCount = socket.read(buffer)) != -1) {
                if (byteCount == 0) continue;
                buffer.flip();
                byte[] bytes = new byte[byteCount];
                buffer.get(bytes);
                stringBuilder.append(new String(bytes, UTF_8));
                buffer.clear();
            }
            String content = stringBuilder.toString();
            if (content.equalsIgnoreCase("x")) {
                break;
            }
            System.out.println("Received: " + content);

            buffer.clear();
            byte[] response = ("hello " + content).getBytes(UTF_8);
            buffer.put(response, 0, Math.min(response.length, buffer.capacity()));
            int totalWritten = 0;
            while (totalWritten < response.length) {
                buffer.flip();
                totalWritten += socket.write(buffer);
                buffer.compact();

                int remaining = response.length - totalWritten;
                if (remaining > 0) {
                    int toWrite = Math.min(remaining, buffer.capacity());
                    buffer.put(response, totalWritten, toWrite);
                }
            }
            socket.close();
        }

        server.close();
    }
}
