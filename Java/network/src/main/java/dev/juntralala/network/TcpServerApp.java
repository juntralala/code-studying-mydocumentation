package dev.juntralala.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServerApp {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080, 200, InetAddress.getByName("127.0.0.1"));
        System.out.println(server.getInetAddress().getHostAddress() + ":" + server.getLocalPort());
        while (!server.isClosed()) {
            Socket request = server.accept();
            System.out.println(request.getClass().getName());
            Scanner scanner = new Scanner(request.getInputStream());
            System.out.println(request.getInputStream().getClass().getName());
            while (!request.isClosed()) {
                String data = scanner.nextLine();
                if ("X".equalsIgnoreCase(data.trim())) {
                    request.close();
                    break;
                }
                System.out.println("Resieved: " + data);
            }
        }
    }
}
