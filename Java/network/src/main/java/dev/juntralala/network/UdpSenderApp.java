package dev.juntralala.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class UdpSenderApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        while (!socket.isClosed()) {
            System.out.print("Send: ");
            String data = scanner.nextLine();
            if ("X".equalsIgnoreCase(data)) {
                socket.close();
                break;
            }
            DatagramPacket packet = new DatagramPacket(data.getBytes(UTF_8), data.getBytes(UTF_8).length, InetAddress.getByName("127.0.0.1"), 8080);
            socket.send(packet);
        }
    }
}
