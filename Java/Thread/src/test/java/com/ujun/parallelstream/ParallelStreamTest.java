package com.ujun.parallelstream;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Salah satu fitur yang menarik di Java Stream adalah, Stream bisa dijalankan secara parallel
 * Secara default, Parallel Stream akan dijalankan di ForkJoinPool, dimana akan di running secara default menggunakan
   Thread sejumlah maksimal total CPU kita (dengan ForkJoinPool.cummomPool())
 * Agar stream bisa berjalan parallel, kita cukup gunakan method parallel()
 */

public class ParallelStreamTest {

    @Test
    public void createParallelStream() {
        Stream<Integer> stream = IntStream.range(1, 1001).boxed();
        stream.parallel()
                .forEach((number) -> System.out.println(Thread.currentThread().getName() + ": " + number));
    }

}
