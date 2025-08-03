package dev.juntralala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class T {

    public static void main(String[] args) {
        // Port tempat server mendengarkan koneksi
        int port = 8888;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server mendengarkan di port " + port);

            // Menerima koneksi client
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client terhubung: " + clientSocket.getInetAddress());

                // Set up streams untuk komunikasi
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Terima pesan dari client
                String inputLine = in.readLine();
                System.out.println("Pesan dari client: " + inputLine);

                // Kirim pesan ke client
                out.println("Halo dari server!");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
