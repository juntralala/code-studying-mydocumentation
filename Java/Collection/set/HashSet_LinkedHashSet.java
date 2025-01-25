package set;

/**
* dibelakang HashSet dan LinkedHashSet sebenarnya sama-sama ada hash table, dimana data di simpan didalam hash table dengan mengkalkulasikan hashCode() function
* yang membedakan adalah, HashSet tidak menjamin data terurut sesuai dengan waktu kita memasukkan data, sedangkan LinkedHashSet menjamin data trurut sesuai waktu kita memasukkan data
* urutan data LinkedHashSet dapat dijaga karna di belakangnya menggunakan double linked list
*/

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSet_LinkedHashSet{
    public static void main(String[] args) {
        
        Set<String> names = new HashSet();
   //     Set<String> names = new LinkedHashSet();
        
        names.add("UJUN");
        names.add("Junaidi");
        names.add("Muhammad");
        names.add("Junaidi");
        names.add("UJUN");
        
        for (var val: names) {
            System.out.println(val);
        }
    }
}