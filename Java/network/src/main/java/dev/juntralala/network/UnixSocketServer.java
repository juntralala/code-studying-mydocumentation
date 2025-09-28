package dev.juntralala.network;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class UnixSocketServer {
    public static void main(String[] args) throws IOException {
        Path socketPath = Path.of("/tmp/java_unix_socket.sock");
        Files.deleteIfExists(socketPath);
        UnixDomainSocketAddress address = UnixDomainSocketAddress.of(socketPath);

        ServerSocketChannel serverChannel = ServerSocketChannel.open(StandardProtocolFamily.UNIX);
        serverChannel.bind(address);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("Server listening on " + socketPath);
        while (serverChannel.isOpen()) {
            SocketChannel socketChannel = serverChannel.accept();
            while (socketChannel.isOpen()) {
                socketChannel.read(buffer);
                StringBuilder builder = new StringBuilder();
                buffer.flip();
                while (buffer.hasRemaining()) {
                    builder.append((char) buffer.get());
                }
                buffer.clear();

                String data = builder.toString();

                if ("X".equalsIgnoreCase(data)) {
                    socketChannel.close();
                    break;
                }
                System.out.println("receive: " + data);
            }
        }

        serverChannel.close();
    }
}
