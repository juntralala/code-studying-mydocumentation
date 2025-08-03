import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class RequestWirhUdp {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Kirim: ");
            String data = scanner.nextLine();
            if (data.equals("x")) {
                break;
            }
            DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), data.length(), InetAddress.getByName("localhost"), 8080);
            socket.send(datagramPacket);
        }

        socket.close();
    }
}
