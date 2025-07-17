package com.muhammad.junaidi;

/**
 * Java Stream juga mendukung operasi untuk melakukan pengurutan data Stream nya
 * Secara default, data akan diurutkan mengikuti Comparable yang terdapat di data yang ada di Stream
 * Jika ingin mengurutkan secara manual, kita bisa menggunakan Coparator milik kita sendiri
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

/**
 * sorted()                 => mengurutkan berdasarkan comparable bawaan data
 * sorted(Comparator)       => menguarutkan berdasarkan comparator
 */

public class Ordering_Operations_sorted {

    @Test
    public void testSorted() {
        List.of("Adam", "Idris", "Nuh", "Hud", "Sholeh", "Muhammad").stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void testSortedDenganComparator() {
        Comparator<String> reComparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        List.of("Adam", "Idris", "Nuh", "Hud", "Sholeh", "Muhammad").stream()
                .sorted(reComparator)
                .forEach(System.out::println);
    }

}
