package map;

/**
* HashMap adalah implementasi dari Map yang mendistribjsikan Key menggunakan hashCode() function
* karena HashMap sangat bergantung kepada hashCode() function, jadi pastikan kita membuat function hashCode seunik mungkin, karena jika terlalu banyak nilai hashCode yang sama, maka pendistribusian key nya tidak akan optimal sehingga get data di Map akan semakin lambat
* di HashMap pengecekan data duplikat menggunakan method equals() nya
*/

import java.util.HashMap;

public class HashMapApp{
    public static void main(String[] args) {
        HashMap<String, String> ujun = new HashMap();
        ujun.put("name", "Muhammad Junaidi");
        ujun.put("age", "19");
        ujun.put("address", "Handil Labuan Amas");

        System.out.println(ujun.get("name"));
        System.out.println(ujun.get("age"));
        System.out.println(ujun.get("address"));
    }
}