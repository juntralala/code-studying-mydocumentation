package dev.juntralala.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Arrays;

public class UdpReceiverApp {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(new InetSocketAddress("127.0.0.1", 8080));
        byte[] buffer = new byte[128];
        Arrays.fill(buffer, (byte) 0);

        while (!socket.isClosed()) {
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
            socket.receive(datagram);
            String data = new String(datagram.getData()).strip();
            if ("X".equalsIgnoreCase(data)) {
                socket.close();
                break;
            }
            System.out.println("Received: " + data);
            Arrays.fill(buffer, (byte) 32);
        }
        socket.close();
    }
}
