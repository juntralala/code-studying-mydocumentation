package dev.juntralala;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ServerSocketApp {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080, 100, InetAddress.getByName("localhost"));
        while(true) {
            Socket socket = server.accept();
            var input = socket.getInputStream();
            var bytes = input.readAllBytes();
            var text = new String(bytes, UTF_8);
            if (text.equalsIgnoreCase("x")) {
                break;
            }
            System.out.println("recived: " + text);
            var output = socket.getOutputStream();
            output.write("hello %s".formatted(text).getBytes(UTF_8));
            socket.close();
        }
        server.close();
    }
}
