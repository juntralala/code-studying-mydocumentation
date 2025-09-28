package dev.juntralala.network;

import java.io.IOException;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class UnixSocketClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of("/tmp/java_unix_socket.sock");
        UnixDomainSocketAddress udsAddress = UnixDomainSocketAddress.of(path);
        SocketChannel socketChannel = SocketChannel.open(udsAddress);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.isOpen()) {
            System.out.print("send: ");
            String data = scanner.nextLine();
            if ("x".equalsIgnoreCase(data)) {
                socketChannel.close();
                break;
            }
            buffer.put(data.getBytes(UTF_8));
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.clear();
        }
        socketChannel.close();
    }
}
