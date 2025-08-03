package legacyCollection;

/**
 * Hashtable class adalah implementasi dari interface Map yang mirip seperti HashMap
 * sama seperti Vector, semua method di Hashtable memiliki katakunci synchronized, sehingga performanya lebih lambat
   dibandinkan HashMap
 * dan karena di java baru sudah ada juga ConcurrentHashMap, sehingga penggunaan Hastable sudah jarangsekali ditemui
 */

import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {
    public static void main(String[] args) {
        Map<String, String> hashTable = new Hashtable<>();
        hashTable.put("name", "Muhammmad Junaidi");
        hashTable.put("age", "19");
        hashTable.put("adress", "Handil Labuan Amas");

        for (var val : hashTable.keySet()) {
            System.out.println(val);
        }
    }
}
