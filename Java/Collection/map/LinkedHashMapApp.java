/**
* LinkedHashMap adalah implementasi Map dengan menggunakan double linked list
* data LinkedHashMap akan lebih terperediksi karena datanya akan disimpan berurutan dalam linked list sesuai urutan kita memasukan data
* namun perlu diperhatikan, proses get data di LinkedHashMap akan semakin lambat sesuai bertambanya data, karena harus melakukan iterasi data linked list terlebih dahulu
* gunakan LinkedHasMap jika memang kita lebih mementingkan iterasi data Map nya
*/

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapApp {
    public static void main(String[] args) {
        
        ///Map<String, String> names = new HashMap();
        Map<String, String> names = new LinkedHashMap();
        
        names.put("ujun", "Muhammad Junaidi");
        names.put("arif", "Arif Bahtiar");
        names.put("ami", "Ainorahmi");
        names.put("dayat", "Muhaammad Hidayat");
        
        Set<String> keys = names.keySet();
        for (var key : keys) {
        	System.out.println(names.get(key));
        }
    }
}