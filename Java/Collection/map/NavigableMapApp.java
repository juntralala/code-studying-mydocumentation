package map;

/** NavigableMap interface
* NavigableMap adalah turunan dari SortedMap
* kelebihannya NavigableMap memiliki kemampuan navigasi berdasarkan operasi lebih dari, kurang dari dan sejenisnya
* misal, kita ingin mengambil data yang key nye lebih dari key X atau kurang dari key Y, ini bisa di lakukan di NavigableMap
*/

/** METHOD NavigableMa0
* lowerEntry(K) : Entry<K, V>
* lowerKey(K) : K
* floorEntry(K) : Entry<K, V>
* floorKey(K) : K
* cellingEntry(K) : Entry<K, V>
* cellingKey(K) : K
* higherEntry(K) : Entry<K, V>
* higherKey(K) : K
* firstEntry() : Entry<K, V>
* lastEntry() : Entry<K, V>
* pollFirstEntry() : Entry<K, V>
* pollLastEntry()  : Entry<K, V>
* descendingMap() : NavigableMap<K, V>
* navigableKeySet() : NavigableSet<K>
* descendingKeySet() : NavigableSet<K>
* subMap(K, boolean, K, boolean) : NavigableMap<K, V>
* headMap(K, boolean) : NavigableMap<K, V>
* tailMap(K, boolean) : NavigableMap<K, V>
*/

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {

        NavigableMap<String, String> navigable = new TreeMap<>();
        navigable.put("ujun", "Muhammad Junaidi");
        navigable.put("lana", "Ahmad Maulana");
        navigable.put("asad", "Muhammad Arsad");
        navigable.put("amang", "M Nor");
        navigable.put("ipul", "Saipul Bahri");
        navigable.put("mahfuz", "Muhammad Mahfuz Amin");

        for (var key : navigable.keySet()) {
            System.out.println(key);
        }

        System.out.println("\n" + navigable.lowerKey("lana"));
        System.out.println("\n" + navigable.higherKey("lana") + "\n");

        NavigableMap<String, String> mapDesc = navigable.descendingMap();
        for (var key : mapDesc.keySet()) {
            System.out.println(key);
        }

    }
}