/**
* collection adalah hal umum yang biasa dimiliki oleh bahasa pemrograman, seperti PHP, python, ruby, dll
* collection atau kadang disebut container adalah object yang mengumpulkan atau berisi data-data mirip, seperti Array
* java telah menyediakan class-class collection yang bisa kangsung kitagunakan, tanka menambah liblary
* semua class di java adakah generic class
*
* Interfaces, ini adalah contract representasi dari collection, semua collection di java memiliki interface, sehingga jika kita mau, kita bisa membuat implementasinya sendiri
* Implementations, kita tidak perlu khawatir, kita bisa menggunkan implementasi yang sudah di sediakan di java, semua interface sudah memiliki implementasi class nya di java collection
* Algorithms, java juga sudah menyediakan algoritma-algoritma yang umum digunakan di collection, seperti penacarian, pengurutan, dll
*/

/**
* selain Iterable interface, parent class untuk semua collectiom di java adalah Collection interface
* kalau Iterable interface digunakan sebagai kontrak untuk meng-iterasi data secara sequential
* Collection interface merupakan kontrak untuk memanipulasi isi data collection, seperti menambah data, menghapus, dan menegcek isi data collection
* tidak ada direct implementation untuk Collection, karna Collction akan dibagi lagi menjadi List, Set, dan Queue
*/

/** METHOD Collections
* size():int
* isEmpty():T[]
* contains(Object):boolean
* toArray():T[]
* toArray(T[]):T[]
* toArray(IntFunction<T[]>):T[]
* add(E):boolean
* remove(Object):boolean
* containsAll(Collection<?>):boolean
* addAll(Collection<? extends E>):boolean
* removeAll(Collections<?>):boolean
* removeIf(Predicate<? super E>):boolean
* retainAll(Collection<?>):boolean
* clear():void
* stream():Stream<E>
* parallelStream():Stream<E>
*/

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        
        collection.add("Junaidi");
        collection.add("Humaidi");
        collection.addAll(List.of("ujun", "Dawi", "Idi", "Alia"));
        
        for(var val : collection) {
        	System.out.println(val);
        }
        
        System.out.println("\n\tREMOVE");
        
        collection.remove("Junaidi");
        collection.remove("Ramadan");
        collection.removeAll(List.of("Humaidi", "Idi"));
        
        for(var val : collection) {
        	System.out.println(val);
        }
        
        System.out.println("\n\tCONTAINS");
        
        System.out.println(
            collection.contains("ujun") + "\n"+
            collection.contains("Junaidi") + "\n"+
            collection.containsAll(List.of("Alia", "Dawi"))
        );
        
        System.out.println(collection.size());
    }
}

