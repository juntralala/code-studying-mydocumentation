package com.muhammad.junaidi;

/**
 * Java Stream operasi untuk mendukung proses aggregate
 * Seperti menghhitung jumlah data, menghitung data max data data min
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

// Aggregate Operation bersifat terminal
// max dan min menreturn Optional
/**
 * max()        => mencari data max sesuai Comparator
 * min()        => mencari data min berdasarkan Comparator
 * count        => mengambil jumlah data
 */

public class Aggregate_Operations_max_min_count {

    @Test
    public void testMax() {
        List.of("Jibril", "Mikael", "Munkar", "Nakir", "Rakib", "Atid", "Izrail", "Israfil", "Malik", "Riduan").stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    @Test
    public void testmin() {
        List.of("Jibril", "Mikael", "Munkar", "Nakir", "Rakib", "Atid", "Izrail", "Israfil", "Malik", "Riduan").stream()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    @Test
    public void testCount() {
        long total = List.of("Jibril", "Mikael", "Munkar", "Nakir", "Rakib", "Atid", "Izrail", "Israfil", "Malik", "Riduan").stream()
                .count();
        System.out.println(total);
    }

}
