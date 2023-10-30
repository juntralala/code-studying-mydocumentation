package iterable_iterator;

/**
* tidak ada magic di java, sebenar nya for-each bisa terjadi di iterable karna ada method iterator() yang mengembalikan object iterator
* iterator adalah interface yang mendifinisikan cara kita mengakses ilemet-ilemet secara sequential
* for-each sendiri muncul pada java 5, sebelum java 5 untuk melakukan iterasi collection, biasanya dilakukan manual menggunakan iterator object
*/

import java.util.List;
import java.util.Iterator;

public class IteratorApp {
    public static void main(String[] args) {
        Iterable<String> names = List.of("ujun", "Udin", "madan");
        Iterator<String> iterator = names.iterator();
        
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}