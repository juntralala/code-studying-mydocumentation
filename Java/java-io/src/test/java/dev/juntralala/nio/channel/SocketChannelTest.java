package dev.juntralala.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

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
            if (channel.finishConnect()) break; // finishConnect wajib dipanggil di non-blocking socket, karna method connect saja tidak menyelesaikan koneksi
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
    public void testNonBlockingWithSelector() throws IOException {
        Selector selector = null;
        SocketChannel socket = null;

        try {
            // 1. Setup
            socket = SocketChannel.open();
            socket.configureBlocking(false);
            selector = Selector.open();

            // 2. Connect
            socket.connect(new InetSocketAddress("localhost", 8080));
            ByteBuffer writeBuffer = ByteBuffer.wrap("Muhammad junaidi".getBytes(UTF_8));
            socket.register(selector, SelectionKey.OP_CONNECT, writeBuffer);

            // 3. State tracking
            boolean isConnected = false;
            boolean dataSent = false;
            boolean dataReceived = false;

            // 4. Event loop
            while (!dataReceived) {
                // Block until event available (with timeout)
                int readyChannels = selector.select(10_000);

                if (readyChannels == 0) {
                    System.out.println("Timeout waiting for events");
                    break;
                }

                // 5. Process all ready keys
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove(); // ALWAYS remove processed key

                    try {

                        // CONNECT event
                        if (key.isConnectable() && !isConnected) {
                            SocketChannel channel = (SocketChannel) key.channel();

                            // Finish connection
                            if (channel.isConnectionPending() && channel.finishConnect()) {
                                System.out.println("✓ Connected to " + channel.getRemoteAddress());
                                isConnected = true;
                                // Switch to WRITE mode
                                key.interestOps(SelectionKey.OP_WRITE);
                            } else {
                                System.err.println("✗ Failed to finish connection");
                                dataReceived = true; // exit loop
                            }
                        }

                        // WRITE event
                        if (key.isWritable() && isConnected && !dataSent) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer buffer = (ByteBuffer) key.attachment();

                            // Write data
                            int bytesWritten = channel.write(buffer);

                            if (!buffer.hasRemaining()) {
                                System.out.println("✓ Sent " + buffer.position() + " bytes");
                                dataSent = true;

                                // Switch to READ mode
                                key.interestOps(SelectionKey.OP_READ);

                                // Replace attachment with read buffer
                                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                                key.attach(readBuffer);
                            }
                        }

                        // READ event
                        if (key.isReadable() && dataSent) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer buffer = (ByteBuffer) key.attachment();

                            // Read data
                            int bytesRead = channel.read(buffer);

                            if (bytesRead == -1) {
                                // Server closed connection
                                System.out.println("✗ Connection closed by server");
                                dataReceived = true; // exit loop
                            } else if (bytesRead > 0) {
                                // Process received data
                                buffer.flip();
                                byte[] data = new byte[buffer.remaining()];
                                buffer.get(data);
                                System.out.println("✓ Received: " + new String(data, UTF_8));

                                dataReceived = true; // exit loop
                            }
                        }

                    } catch (IOException e) {
                        System.err.println("✗ Error processing key: " + e.getMessage());
                        key.cancel();
                        key.channel().close();
                        dataReceived = true; // exit on error
                    }
                }
            }

            System.out.println("✓ Communication completed");

        } catch (IOException e) {
            System.err.println("✗ Fatal error: " + e.getMessage());
            throw e;
        } finally {
            // 6. Cleanup
            if (socket != null && socket.isOpen()) {
                try {
                    socket.close();
                    System.out.println("✓ Socket closed");
                } catch (IOException e) {
                    System.err.println("✗ Error closing socket: " + e.getMessage());
                }
            }
            if (selector != null && selector.isOpen()) {
                try {
                    selector.close();
                    System.out.println("✓ Selector closed");
                } catch (IOException e) {
                    System.err.println("✗ Error closing selector: " + e.getMessage());
                }
            }
        }
    }
}
