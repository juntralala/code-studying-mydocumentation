package ujunAlRantaui.comparator;

import ujunAlRantaui.comparable.Person;

import java.util.Arrays;
import java.util.Comparator;

/** Comparator Interface
 * Jika kita ingin mengurutkan class yang kita gunakan, cukup mudah dengan implement interface Comparable
 * Namun bagaimana jika class tersebut milik otang lain? Tifak bisa kita ubah?
 * Maka kita bisa menggunakan interface generic yang bernama Comparator
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Comparator.html
 */

public class ComparatorApp {

    public static void main(String[] args){

        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.compareTo(person2);
            }
        };

        Person[] people = {
                new Person("UJUN", "Rantau Darat"),
                new Person("Junaidi", "Handil Labuan Amas"),
                new Person("Taichou", "Tidak Diketahui")
        };

        Arrays.sort(people, personComparator);

        System.out.println(Arrays.toString(people));

    }

}