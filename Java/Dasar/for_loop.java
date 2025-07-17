import java.util.Scanner;
public class for_loop {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.print("masukan n : ");
        int n = userInput.nextInt();
        int first = 3;
        int selisih = 3;

        for (int i = 1 ; i<n ; i++){
            System.out.println(first);
            first += selisih;
        }
        System.out.println(first);

        // init statement - kondsi - post statement tidak wajib diisi
        // jika kondisi tidak diisi nilai default nya true

        for (;;) {
            System.out.println("perulanagn tanpa henti");
        }

    }
}
