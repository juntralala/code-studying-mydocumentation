package map; /**
* WeakHashMap adalah implementasi Map sama seperti HashMap
* yang membesakan adalah WeakHashMap menggunakan weak key, dimana jika tidak digunakan lagi maka secara otomatis data WeakHashMap akan di hapus
* artinya jika terjadi garbage collection di java, bisa dimungkinkan data di WeakHashMap akan dihapus
* WeakHashMap cocok untuk menyimpan data chache di memori secara sementara
*/

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapApp {
    public static void main(String[] args) {
        Map<String, String> myIndentity = new WeakHashMap();
        
        for(int i = 0; i < 1000_000 ; i++) {
            myIndentity.put(String.valueOf(i), String.valueOf(i));
        }
        myIndentity.get(1);
        
        System.gc(); // mengaktigkan garbage collection
        
        System.out.println(myIndentity.size());
    }
}