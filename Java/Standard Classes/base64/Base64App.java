package base64;

import java.util.Base64;

/**
 * sejak java 8, sudah disediakan class untuk melakukan encoding base64
 *
 * base64 ialah encoding diguakan untuk mengubah binary data menjadi text yang aman ( dalam hal parsing bukan security)
 */



public class Base64App {
    public static void main(String[] args) {
        String nama = "Muhammad Junaidi";

        String encoded = Base64.getEncoder().encodeToString(nama.getBytes());

        byte[] bytes = Base64.getDecoder().decode(encoded);
        String result = new String(bytes);

        System.out.println(result);
    }
}
