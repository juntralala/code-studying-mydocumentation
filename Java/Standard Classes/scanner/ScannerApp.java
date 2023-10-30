package scanner;

// next()     -> menambil input string
// nextByte()
// nextShort()
// nextInt()
// nextLong()

import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Nama mu? ");
        var nama = scanner.next();
        System.out.print("berapa umur mu? ");
        var umur = scanner.nextInt();

        System.out.printf("Halo %s, umur kamu %d", nama, umur);

    }
}
