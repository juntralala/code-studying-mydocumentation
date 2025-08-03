package entry;

/**
 * saat kita menimpan data di Map, data disimpan dalam pair(key-value)
 * di java Coleections, implementasipar bernama Entry
 * Entry adalah interface sederhana yang berisikan method untukmeambil key dan value
 */

/** method di Entry interface
 * getKey(): K
 * getValue(): V
 * getValue(V): V
 * comparingByKey(): Comparator<Entry<K,V>>
 * comparingByValue(): Comparator<Entry<K,V>>
 * comparingByKey(Comparator<? super K>): Comparator<Entry<K,V>>
 * comparingByValue(Comparator<? super K>): Comparator<Entry<K,V>>
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class EntryApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Muhammad Junaidi");
        map.put("age", "19");
        map.put("address", "Handil Labuan Amas");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (var entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
