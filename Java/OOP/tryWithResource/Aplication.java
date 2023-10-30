package tryWithResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aplication {
    public static void main(String[] args) {

        // dengan try with resource
        try (var reader = new BufferedReader(new FileReader("teks.txt"))) {
            while (true) {
                String teks = reader.readLine();
                if (teks != null) {
                    System.out.println(teks);
                } else {
                    break;
                }
            }
        } catch (Throwable e) {

        }

        // tanpa try with resource
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader( new FileReader("teks.txt"));
//            while (true) {
//                String teks = reader.readLine();
//                if (teks != null) {
//                    System.out.println(teks);
//                } else {
//                    break;
//                }
//            }
//        } catch (Throwable e) {
//
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException ioe) {
//                    System.out.println("Error menutup resource : " + ioe.getMessage());
//                }
//            }
//        }

    }
}
