package dev.juntralala;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

import static java.nio.channels.SelectionKey.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ServerSocketChannelWithSelectorApp {
    public static void main(String[] args) throws IOException {
        var server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress("localhost", 8080));
        var selector = Selector.open();
        server.register(selector, OP_ACCEPT);

        while (true) {
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            var keyIterator = keys.iterator();
            if (keyIterator.hasNext()) {
                var key = keyIterator.next();
                keyIterator.remove();
                if (key.isAcceptable()) {
                    var serverChannel = (ServerSocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(8);
                    SocketChannel socket = serverChannel.accept();
                    socket.configureBlocking(false);
                    socket.register(selector, OP_READ | OP_WRITE, buffer);
                }
                if (key.isWritable()) {
                    var socket = (SocketChannel) key.channel();
                    var buffer = ByteBuffer.wrap("Hello world".getBytes(UTF_8));
                    while (buffer.hasRemaining()) {
                        socket.write(buffer);
                    }
                    key.interestOps(key.interestOps() & (~OP_WRITE));
                }
                if (key.isReadable()) {
                    var socket = (SocketChannel) key.channel();
                    var buffer = (ByteBuffer) key.attachment();
                    int byteCount = socket.read(buffer);
                    if (byteCount == -1) {
                        key.cancel();
                        socket.close();
                        buffer.clear();
                    }
                    if (byteCount > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[byteCount];
                        buffer.get(bytes);
                        IO.println("Read from %s : %s".formatted(socket.getRemoteAddress(), new String(bytes, UTF_8)));
                        buffer.clear();
                    }
                }
            }
        }
    }
}