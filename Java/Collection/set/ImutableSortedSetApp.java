package list;

/** membuat imutable SortedSet
* Collections.emtySortedSet()
* Collection.unmodifiableSortedSet()
*/

import data.Person;
import data.PersonComparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Collections;

public class ImutableSortedSetApp {
    public static void main(String[] args) {
        SortedSet<Person> emty = Collections.emptySortedSet();
        
        SortedSet<Person> people = new TreeSet<>(new PersonComparator());
        people.add(new Person("ujun"));
        people.add(new Person("Ipul"));
        people.add(new Person("unai"));
        people.add(new Person("wawan"));
        
        SortedSet<Person> imutable = Collections.unmodifiableSortedSet(people);
        
        for(var val : people) {
            System.out.println(val.getName());
        }
    }
}