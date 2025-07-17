package iterable_iterator;
/**
* Iterable adalah parent untuk semua collection di java, kecuali Map
* Iterable sendiri sangat sederhana, digunakan hanya agar mendukung for-each loop
* Karena semua collection di java pasti implement Iterable, secara otomatis maka semua collection di java mendukung menggunakan for-each, jadi bukan Array saja
*/

import java.util.List;

public class IterableApp {
    public static void main(String[] args) {
        Iterable<String> names = List.of("ujun", "Dawi", "Ilham", "Udin");
        
        for (var val : names) {
            System.out.println(val);
        }
        
    }
}