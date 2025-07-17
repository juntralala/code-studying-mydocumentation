package com.ujun.synchronizer;


import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CyclingBarrier
 * CyclicBarrier merupakan fitur yang bisa kita gunakan untuk saling menunggu, sampai jumlah thread yang menunggu terpenuhi
 * Diawal kita akan tentukan berapa jumlah thread yang menunggu, jika sudah terpenuhi, maka secara otomatis proses menunggu akan selesai
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CyclicBarrier.html
 */

public class CyclicBarrierTest {
    private final Random random = new Random();

    @Test
    public void cyclingBarrier() throws InterruptedException {
        final var cyclicBarrier = new CyclicBarrier(5);
        final var service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            final int task = i;
            service.execute(() -> {
                try {
                    Thread.sleep(random.nextLong(1000, 10_000));
                    System.out.println("task-" + task  + " is waiting...");
                    cyclicBarrier.await();
                    System.out.println("task-" + task + " done Waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.awaitTermination(10, TimeUnit.MINUTES);
    }
}
