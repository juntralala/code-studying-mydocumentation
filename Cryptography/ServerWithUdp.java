import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Arrays;

public class ServerWithUdp {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080, InetAddress.getByAddress(new byte[]{0, 0, 0, 0}));
        byte[] buffer = new byte[4096];
        Arrays.fill(buffer, (byte) 0x20);
        new ServerSocket();

        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(datagramPacket);
            String received = new String(datagramPacket.getData());
            System.out.println("Receive: " + received);
            Arrays.fill(buffer, (byte) 0x20);
        }
    }
}
