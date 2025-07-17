package list;

/**
* ArrayList adalah implementasi List menggunakan Array
* default kapasitas Array di ArrayList adalah 10
* namun ketika kita memasukkan data dan Array telah penuh, maka secara otomatis ArrayList akan membuatkan array baru dengan kapasitas baru dengan kapasitas lama + data baru
*/

/** method yang ada di List
 * addAll(int, Collection<? extends E>) : boolean
 * replaceAll(UnaryOperator<E>) : void
 * sort(Comparator<? super E>) : void
 * get(int) : E
 * set(int, E) : void
 * add(index , E)
 * remove(int) : E
 * indexOf(Object) : int
 * lastIndexOf(Object) : int
 * listIterator() : ListIterator<E>
 * listIterator(int) : ListIterator<E>
 * subList(int, int) : List<E>
 */

import java.util.ArrayList;
import java.util.List;

public  class ArrayListApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList();
    //    List<String> names = new LinkedList(); // semua method pada ArrayList dan LinkedList sama
        
        names.add("ujun");
        names.addAll(List.of("Dawi", "Rezki", "unai", "amat"));
        
        names.set(1, "adul");
        names.remove(0);
        
        for (var val : names) {
            System.out.println(val);
        }
    }
}