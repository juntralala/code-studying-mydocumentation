package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;

/** Reduse Operations
 * Java Stream juga menyediakan sebuah operasi bernama reduce
 * Reduce bisa bisa digunakan untuk melakukan proses agregate secara manual
 * Misal kita ingin menjumlahkan seluruh angka yang terdapat di Stream, kita bisa melakukan ini menggunakan reduce operator
 * Di bahasa pemrograman lain, reduce mirip seperti fold
 */

public class Reduse_Agregate_Operations_reduce {

    @Test
    public void testSum() {
        List<Integer> numbers = List.of(2,5,4,2,10);

        Integer result = numbers.stream()
                .reduce(0, (value, item) -> value + item);

        System.out.println(result);
    }

}
