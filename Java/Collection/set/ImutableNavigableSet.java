/** membuat imutable NavigableSet
* Collections.emptyNavigableSet()
* Collections.unmodifiableNavigableSet()
*/

import java.util.Collections;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Set;

public class ImutableNavigableSet{
    public static void main(String[] args) {
        NavigableSet<String> emptySet = Collections.emptyNavigableSet();
        
        NavigableSet<String> names = new TreeSet();
        names.addAll(Set.of("ujun", "dawi", "amin", "bana", "duan"));
        NavigableSet<String> imutable = Collections.unmodifiableNavigableSet(names);
    }   
}