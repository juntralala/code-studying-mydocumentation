package mapDefaultMethod;
// penjelesan detailada di CollectionDefaultMethodApp

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**                                             keterangan
 * getOrDefault(key, defaultValue)              mengambil data berdasarkan key, jika tidak ada return defaulValue
 * forEach(consumer)                            melakukan iterasi seluruh data key-value
 * replaceAll(function)                         mengubah seluruh data value
 * putIfAbsent(key, value)                      simpan data ke map jika belum ada
 * remove(key, value)                           hapus jiak key-value sama
 * replace(key, oldValue, newValue)             ubah value jika key-value sama key-oldValue
 * computeIfAbsent(key, function)               ubah key dengan value hasil function jika belum ada
 * computeIfPresent(key, function)              ubah key dengan value hasil function jika sudah ada
 * dll
 */

public class MapDefaultMethodApp {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("ujun", "Muhammad Junaidi");
        map.put("iki", "Muhammad Rezki");
        map.put("ami", "Ainorahmi");
        map.put("akbar", "Muhammad Rafly Aulia Akbar");

        map.forEach(new BiConsumer<String, String>() {
            public void accept(String s, String s2) {
                System.out.println(s + " : " + s2);
            }
        });

    }
}
