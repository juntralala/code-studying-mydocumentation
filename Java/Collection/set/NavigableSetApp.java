package set;

/**
* NaviganleSet adalah turunan dari SortedSet
* NavigableSet menambahkan method-method navigasi untuk melakukan pencarian ilemen, seperti mencari elemen yang lebih dari, atau kurang dari, membalikan urutan elemen, dll
*/

/** diantara method² nya
* lower(E) : E                                           // kurang dari
* floor(E) : E                                           // kurang dari sama sengan
* calling(E) : E                                         // lebih dari sama dengan
* higher(E) : E                                          // lebih dari
* pollFirst() : E                                        // mengambil dan menghapus data pertama
* pollLast() : E                                         // mengambil dan menghapus data terakhir
* descendingSet() : NavigableSet<E>
* descendingIterator() : Iterator<E>
* subSet(E, boolean, E, boolean) : NavigableSet<E>
* headSet(E, Boolean) : NavigableSet<E>                  // mengambil data dari awal sampai elemen parameter
* tailSet(E, Boolean) : NavigableSet<E>                  // mengambil data dari akhir sampai elemen parameter
*/

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Set;

public class NavigableSetApp{
    public static void main(String[] args){
        NavigableSet<String> names = new TreeSet();
        names.addAll(Set.of("Ujun", "Bahri", "Arif", "Ami", "Dayat"));
        
        for(var val : names) {
            System.out.println(val);
        }
        
        NavigableSet<String> namesReverse = names.descendingSet();
        NavigableSet<String> dayat = names.tailSet("Dayat", true);
        
        System.out.println();
        for(var val : dayat) {
            System.out.println(val);
        }
        
    }
}