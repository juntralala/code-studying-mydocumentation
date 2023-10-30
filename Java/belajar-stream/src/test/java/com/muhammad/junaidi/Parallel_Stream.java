package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/** ParallelStream
 * Salah satu fitur yang menarik di Java Stream adalah, Stream bisa dijalankan secara parallel
 * Materi Parallel Programming akan dibahas lebih detail divideo tutorial Java Thread
 * Secara garis besar, parallel artinya beberapa berjalan secara bersamaan
 * Secara default, Parallel Stream akan dijalankandi FOrkJoinPool, diamna akan dirunning secara default menggunakan
   thread sejumalah maksimal total CPU kita
 */

public class Parallel_Stream {

    @Test
    public void testSequential() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));
    }

    @Test
    public void testParallel() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .parallel()
                .forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));
    }

}
