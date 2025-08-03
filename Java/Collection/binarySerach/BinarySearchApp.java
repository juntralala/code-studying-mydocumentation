package binarySerach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * secara default List di java memiliki fitur search dan get data, namun mplementasi nya menggunakan sequential search,
   artinya data di cek satu persatu dari awal
 * salah satu algoritma yang populer adalah binery search, namun binary search hanya bisa di lakukan jika datanya telah berurutan
 * untungnya di java telah ada implementasi binary search, sehingga kita tidak perlu lagi membuat nya secara manual
 */

/** cara melakukan binary search di java
 *  Collections.binarySearch(list, value)
 *  Collections.binarySearch(list, value, comparator)
 */

public class BinarySearchApp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1000);
        for (var angka = 0 ; angka<1000 ; angka++ ) {
            list.add(angka);
        }

        int index = Collections.binarySearch(list, 777);
        System.out.println(index);

    }
}
