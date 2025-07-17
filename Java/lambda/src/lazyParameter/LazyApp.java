package lazyParameter;

import java.util.function.Supplier;

/**
 * java tidak memiliki fitur lazy parameter seperti di bahasa pemrograman lain seperti scala dan dart
 * lazy parameter artinya, parameter tersebut tidak akan di eksekusi kecuali ketika di akses
 * untungnya, dengan lambda kita bisa membuat parameter layaknya lazy parameter
 */

public class LazyApp {
    public static void main(String[] args) {
        testScore(85, () -> getName());

    }

    public static void testScore(int nilai, Supplier<String> name) {
        if (nilai > 80) {
            System.out.printf("Selamat %s ,anda lulus\n",name.get());
        } else {
            System.out.println("Maaf, anda belum lulus");
        }
    }

    public static String getName() {
        System.out.println("Method getName() di panggil");
        return "UJUN";
    }
}
