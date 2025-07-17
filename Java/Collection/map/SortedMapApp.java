package  map;

/** SortedaMap interface
* SortedMap adalah implementasi Map dengan key yang diurutkan sesuai Comparable atau Comparator
* SortedMap cocok padq kasus Map yang posisi key nya harus terurut
*/

/** method di SortedMap
* comparator() : Comparator<E>
* headMap(K) : SortedMap<K, V>
* subMap(K, K) : SortedMap<K, V>
* tailMap(K) : SortedMap<K, V>
* firstKey() : K
* lastKey() : K
*/

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
    public static void main(String[] args) {
        SortedMap<String, String> myIdentity = new TreeMap();
        
        myIdentity.put("nama", "Muhammad Junaidi");
        myIdentity.put("age", "19");
        myIdentity.put("address", "Handil Rantau");
        
        for(var key : myIdentity.keySet()) {
        	System.out.println(key);
        }
    }
}