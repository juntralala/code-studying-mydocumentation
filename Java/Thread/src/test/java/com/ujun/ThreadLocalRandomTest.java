package com.ujun;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/** ThreadLocalRandom
 * Pada materi-materi sebelumnya, kita sering menggunakan class Random untuk membuat angka random
 * Saat menggunakan object Random secara parallel, maka di dalam class Random kita akan melakukan sharing variable, hal ini membuat class Random tidak aman dan juga lambat
 * Oleh karena itu terdapat class ThreadLocalRandom, ThreadLocalRandom merupakan class yang seperti ThreadLocal, namun spesial untuk Random, sehingga kita bisa membuat angka random tanpa khawatir dengan race condition, karena object Random nya akan berbeda tiap thread
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
 */

public class ThreadLocalRandomTest {

    @Test
    public void testThreadLocalRandom() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    int nextInt = ThreadLocalRandom.current().nextInt();
                    System.out.println(nextInt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
    }


    /** ThreadLocalRandom Stream
     * Fitur lainnya di ThreadLocalRandom adalah, dia memiliki fitur untuk membuat random number secara stream
     * Hal ini mempermudah kita ketika ingin melakukan random number tanpa harus pusing membuat perulangan secara manual
     * ada banyak method di ThreadLocalRandom seperti ints(), longs() dan doubles() yang mengembalikan data stream
     */
    @Test
    public void testRandomStream(TestInfo info) throws InterruptedException {
        var execute = Executors.newCachedThreadPool();
        execute.execute(() -> {
            ThreadLocalRandom.current().ints(1000, 0, 1000)
                    .forEach(System.out::println);
        });

        execute.shutdown();
        execute.awaitTermination(2, TimeUnit.MINUTES);
    }
}
