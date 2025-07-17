package regex;

/**
 * Regular Expression atau di singkat Regex adalah cara melakukan pola pencarian
 *
 * biasanya dilakuakan untuk pencarian data dalam string
 *
 * Secara sederhana, mungkin kita sering menggunakan pencarian text, entah di tex editor atau di aplikasi word
 *
 * Regex adalah pencarian yang lebih advanceed rai pencarian text biasanya, misal kita ingin mencari semua kata yang
 * mengandung di awali huruf a dan diakhiri huruf a DLL
 *
 * REGEX PACKAGE:
 * java sudah menyediakan package java.util.regex yang beisikan utilitas untuk melakukan proses regular expression
 *
 * secara garis besar terdapat 2 class yag dapat kita gunakan, yaitu Pattern class dan matcher class
 *
 * Pattern class adalahrepresentasi hasil compilasi dari pola regular expression yang kita buat
 *
 * Macher class adalah engine untuk melakukan pencarian dari pattern yang sudah kita buat
 *
 * penjelasan regex sangan panjang, untuk lebih lengkapnya buka dokumentation
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexApp {
    public static void main(String[] args) {

        String namaku = "Muhammad Junaidi bin abdul wahid";

        Pattern pattern = Pattern.compile("[a-zA-Z]*[a][a-zA-Z]*");

        Matcher matcher = pattern.matcher(namaku);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
