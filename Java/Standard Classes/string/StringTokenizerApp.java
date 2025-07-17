package string;

import java.util.StringTokenizer;

/**
 * StringTokenizer class adalah class yang bisa digunakan untuk memotong String menjadi token atau Stringyang lebih kecil
 *
 * kita bisa memotong string dengan delimiter yang kita mau
 *
 * kegunaan StringTokenizer hampir sama dengan methos String.plit(), perbedaanya adalah StringTokenizer Bersifat lazy
 * artinya string tidak akan dipotong sebelum memanggil method .nextToken() dan iya di pisah secara satu persatu,
 * jadi StringTokenizer lebih hemat memori dibandingkan .splt() jika datanya besar, karna split() akan memotong
 * string nya sekaligus dalam satu waktu, misal data nya 1GB maka split() akan meload seluruh datanya ke memori
 */

public class StringTokenizerApp {
    public static void main(String[] args) {
        String name = "Muhammad Junaidi bin abd Wahid";

        StringTokenizer tokenizer = new StringTokenizer(name, " ");

        while (tokenizer.hasMoreTokens()) { // jika masih ada data maka return true
            String token = tokenizer.nextToken();  //memtong string
            System.out.println(token);
        }

    }
}
