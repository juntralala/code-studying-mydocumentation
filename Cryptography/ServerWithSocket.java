import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWithSocket {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket server = new ServerSocket(8080, 1000, InetAddress.getByAddress(new byte[]{0, 0, 0, 0}))
        ) {
            System.out.println("server running = http://" + server.getInetAddress().getHostAddress() + ":" + server.getLocalPort());
            while (true) {
                Socket socket = server.accept();
                Thread.ofVirtual().start(() -> {
                    try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                        String data;
                        while ((data = inputStream.readLine()) != null) {
                            System.out.println("data = " + data);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            }
        }
    }
}
