package dev.juntralala.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_CONNECT;
import static java.nio.charset.StandardCharsets.UTF_8;

/*
note: method read():
   1. kalau blocking: tidak akan return 0
   2. non blocking: mungkin saja return 0
   return -1 berarti endof file, atau akhir dari data.
 */
public class SocketChannelTest {

    @Test
    public void test() throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
//        var buffer = ByteBuffer.allocate(64);

        var buffer = ByteBuffer.wrap("ujun 123 10101".getBytes(UTF_8));
//        buffer.clear();
//        buffer.flip();
        channel.write(buffer);
        channel.shutdownOutput();
        buffer.clear();

        int byteCount;
        while ((byteCount = channel.read(buffer)) != -1) {
            buffer.flip();
            byte[] receivedBytes = new byte[byteCount];
            buffer.get(receivedBytes);
            System.out.println("recieved: " + new String(receivedBytes));
            buffer.clear();
        }
        channel.close();
    }

    @Test
    public void testNonBlocking() throws IOException { // non block mode lebih baik digunakan bersama selector (yg disini cuman contoh)
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost", 8080));
        while (!channel.finishConnect()) { // connect() bisa belum selesai, jadi harus tunggu dulu sebelum proses selanjutnya
            if (channel.finishConnect()) break;
        }

        var buffer = ByteBuffer.allocate(64);
        buffer.put("Muhammad Junaidi".getBytes(UTF_8));
        buffer.flip();
        channel.write(buffer);
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        channel.shutdownOutput();
        buffer.clear();

        while (true) {
            int byteCount = channel.read(buffer); // read data dari socket
            if (byteCount == -1) break;
            if (byteCount == 0) continue;
            byte[] receivedBytes = new byte[byteCount];
            buffer.flip();
            buffer.get(receivedBytes);
            System.out.println("recieved: " + new String(receivedBytes));
            buffer.clear();
        }
        channel.close();
    }

    @Test
    public void testNonBlockingWithSelector() throws IOException { // bisa pakai beberapa socket langsung by the way (masih ada yang salah, dah lah muak dan malas)
        ByteBuffer buffer = ByteBuffer.wrap("Muhammad junaidi".getBytes(UTF_8));
        SocketChannel socket = SocketChannel.open();
        socket.configureBlocking(false);
        socket.connect(new InetSocketAddress("localhost", 8080));
        Selector selector = Selector.open();
        socket.register(selector, OP_CONNECT, buffer);

        while (true) {
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            if (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();

                if (key.isValid()) {
                    break;
                }

                if (key.isConnectable()) {
                    System.out.println("Connected to " + socket.getRemoteAddress());
                } else {
                    break;
                }
                if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buf = ByteBuffer.allocate(8);
                    int byteCount = sc.read(buf);
                    buf.flip();
                    if (byteCount > 0) {
                        byte[] bytes = new byte[byteCount];
                        System.out.println(new String(bytes));
                    }
                    buf.clear();
                }
                if (key.isWritable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buf = (ByteBuffer) key.attachment();
                    sc.write(buf);

                    while (buf.hasRemaining()) {
                        socket.write(buf);
                    }
                    socket.close();
                    buf.clear();
                }
            }
        }

        socket.close();
    }
}
