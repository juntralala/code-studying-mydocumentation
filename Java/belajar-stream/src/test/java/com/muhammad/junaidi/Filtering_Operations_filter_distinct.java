package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Filtering Operations adalah operasi di Stream yang digunakan untuk melakukan filter data Stream
 * Contohnya, misal kita punya stream data dari 1 sampai 10, lalu kita hanya ingin menggunakan data ganjil saja atau genap
 */

/**
 * filter(U -> Boolean)                           => mengambil data yang masuk kriteria filter
 * distict()                                      => Menghapus semua data duplikat
 */

public class Filtering_Operations_filter_distinct {

    @Test
    public void testFilter() {
        List.of("Ujun", "Muhammad", "Junaidi", "Ipul").stream()
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);
    }

    @Test
    public void TtestDistinct() {

        List.of("Ujun", "Dawi", "Ujun", "Dawi").stream()
                .distinct()
                .forEach(System.out::println);
    }

}
