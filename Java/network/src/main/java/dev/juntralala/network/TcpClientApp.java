package dev.juntralala.network;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientApp {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintStream print = new PrintStream(socket.getOutputStream());

        System.out.println("port: " + socket.getPort());
        System.out.println("address: " + socket.getInetAddress().getHostAddress());
        System.out.println("local address: " + socket.getRemoteSocketAddress());
        System.out.println("local port: " + socket.getLocalPort());
        System.out.println("local address: " + socket.getLocalAddress().getHostAddress());
        System.out.println("local address: " + socket.getLocalSocketAddress());

        while (!socket.isClosed()) {
            System.out.print("Input: ");
            String data = input.nextLine();
            print.println(data);
            if ("X".equalsIgnoreCase(data)) {
                socket.close();
                break;
            }
        }
    }
}
