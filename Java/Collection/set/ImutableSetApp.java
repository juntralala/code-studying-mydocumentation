package set;

/**
* sama seperti di List, pada Set juga ada imutable Set
* cara pembuatan imutable Set di java mirip dengan pembuatan imutable List
*/

/** cara membuat imutable Set
* +==================================+==========================================+
* | method                           | keterangan                               |                           
* + ---------------------------------+------------------------------------------+
* | Colections.emtySet()             | membuat imutable set kosong              | 
* | Collectikns.singleton(e)         | membuat imutable set berisi satu element | 
* | Collections.unmodifiableSet(set) | mengubah mutable set menjadi imutable Set| 
* | Set.of(e...)                      | membuat imutable set dari elemen-elemen  | 
* +==================================+==========================================+
*/

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.EnumSet;

public class ImutableSetApp {
    public static void main(String[] args) {
        
        Set<String> emty = Collections.emptySet();
        
        Set<String> singleSet = Collections.singleton("ujun");
        
        Set<String> myName = new HashSet<>();
        myName.add("Muhammad");
        myName.add("Junaidi");
        myName = Collections.unmodifiableSet(myName);
        
        Set<String> names = Set.of("ujun", "madan", "dawi", "asad");
    }
}