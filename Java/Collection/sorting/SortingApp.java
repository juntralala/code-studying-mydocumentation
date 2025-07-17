package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * sorting adalah algoritma yang sudah biasa kita lakukan
 * di java Collection juga sudah di sediakan cara melakukan pengurutan, jadi kita tidak perlu melakukan pengurutan secara manual
 * namun perlu di ingat, yang bisa di sort hanyalah List, karena Set, Queue, Deque dan Map cara kerja nya khusus,
   pengurutan hanya bisa di lakukan di List
 */

/** cara sorting di list
 * Collections.sort(list)
 * Collections.sort(list, Comparator)
 */

public class SortingApp {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.addAll(List.of("Hendra", "Danu", "Tamjid", "Yazidun", "Syafi'i"));

        // 1 parameter
        Collections.sort(names);

        for (var name : names) {
            System.out.println(name);
        }

        Comparator<String> reverse = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        // 2 parameter
        Collections.sort(names, reverse);

        for (var name : names) {
            System.out.println(name);
        }

    }
}
