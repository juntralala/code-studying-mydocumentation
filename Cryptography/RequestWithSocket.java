import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RequestWithSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Scanner scanner = new Scanner(System.in);

        var output = socket.getOutputStream();
        while (true) {
            System.out.print("Kirim: ");
            String input = scanner.nextLine();
            if (input.equals("x")) {
                break;
            }
            output.write((input + "\n").getBytes());
        }
        output.close();
        socket.close();
    }
}
