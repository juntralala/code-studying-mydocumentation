package data;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}