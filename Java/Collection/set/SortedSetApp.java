package set;

/**
* SortedSet adalah tirunan dari Set, namun di SortedSet elemen-elemen yang disukkan ke SortedSet akan otomatis diurutkan
* jika elemen SortedSet adalah turunan interface Comparable, maka secara otomatis akan diurutkan menggunakan Comparable tersebut
* jika elemen bukan turunan interface Comparable, maka kita bisa menggunakan Comparator untuk memberitahukan SortedSet bagaimana cara mengurutkan elemen-elemen nya
*/

/** method tambahan SortedSet
* comparator() : Comparator<? super E>
* subSet(E, E) : SortedSet<E>
* headSet() : SortedSet<E>             // mengambil semua data dari awal
* tailSet() : SortedSet<E>             // mengambil semua data dari akhir
* firt() : E
* last() : E
*/

import data.Person;
import data.PersonComparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {
        SortedSet<Person> people = new TreeSet<>(new PersonComparator());
        people.add(new Person("ujun"));
        people.add(new Person("Ipul"));
        people.add(new Person("unai"));
        people.add(new Person("wawan"));
        
        for(var val : people) {
            System.out.println(val.getName());
        }
    }
}