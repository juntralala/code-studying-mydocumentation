package legacyCollection;

/**
 * Vector class adalah implementasi dari interface List
 * cara kerja Vector mirip dengan ArrayList, yang membedakan adalah semua method di Vector menggunakan kata kunci synchronized
   yang artinya di thread safe
 * namun probelemnya adalah, karena semua method menggunakan kata kunci synchronized, secara otomatis impact nya ke performance
   yang menjadi lambat di bandingkan ArrayList
 * lantas bagai mana jika kita ingin membuat List yang bisa digunakan di proses paralel? di versi java baru, sudah disediakan
   yang lebih canggih untuk itu, oleh karena itu penggunaan vector sudah jarang sekali ditemui sekarang
 */

import java.util.List;
import java.util.Vector;

public class VectorApp {
    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        vector.add("ujun");
        vector.add("Dawi");
        vector.add("Adol");
        vector.add("Saman");

        System.out.println(vector);
    }
}
