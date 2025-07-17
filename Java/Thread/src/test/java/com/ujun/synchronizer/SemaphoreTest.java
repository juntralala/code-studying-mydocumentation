package com.ujun.synchronizer;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore
 * Semaphore merupakan class yang digunakan untuk manage data counter
 * Nilai counter bisa naik, namun ada batas maksimal nya, jika batas maksimal nya sudah tercapai, semua thread yang akan
 * mencoba menaikkan harus menunggu, sampai ada thread lain yang menurunkan nilai counter
 * Semaphore cocok sekali misal untuk menjaga agar thread berjalan pada maksimal total counter yang sudah kita tentukan
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/Semaphore.html
 */

public class SemaphoreTest {

//    public static void main(String[] args) {
//
//        final Semaphore semaphore = new Semaphore(2);
//        final ExecutorService service = Executors.newFixedThreadPool(100);
//
//        for (int i = 0; i < 1000; i++) {
//            service.execute(() -> {
//                try {
//                    semaphore.acquire();
//                    Thread.sleep(200);
//                    System.out.println("Finish");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    semaphore.release();
//                }
//            });
//        }
//    }

    @Test
    public void testSemaphore() throws InterruptedException {
        final var semaphore = new Semaphore(2);
        final var service = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(200);
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        service.awaitTermination(10, TimeUnit.MINUTES);
    }
}
