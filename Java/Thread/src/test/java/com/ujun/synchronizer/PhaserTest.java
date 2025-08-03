package com.ujun.synchronizer;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Phaser
 * Phaser merupakan fitur synchronizer yang mirip dengan CyclicBarrier dan CountDownLatch, namun lebih flexible
 * Sebelumnya, untuk jumlah counter atau thread nya sudah ditentukan di awal, namun pada Phaser, bisa berubah
 * dengan menggunakan method register() atau bulkRegister(int), dan untuk menurunkan bisa menggunakan
 * method arrive...(), atau bisa menggunakan await...(int) untuk menunggu sampai jumlah yang register tertentu
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/Phaser.html
 */

public class PhaserTest {

    private Random random = new Random();

    @Test
    public void phaserAsCountDownLatch() throws InterruptedException {
        final var phaser = new Phaser();
        final var service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            final int task = i;
            service.execute(() -> {
                try {
                    phaser.register();
                    System.out.println("Start Task - " + task);
                    Thread.sleep(2000);
                    System.out.println("End Task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    phaser.arrive();
                }
            });
        }

        service.execute(() -> {
            phaser.awaitAdvance(0);
            System.out.println("All Tasks Finished");
        });

        service.awaitTermination(5, TimeUnit.MINUTES);
    }

    @Test
    public void phaserAsCyclicBarrier() throws InterruptedException {
        final var phaser = new Phaser();
        final var service = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);

        for (int i = 0; i < 20; i++) {
            final int task = i;
            service.execute(() -> {
                try {
                    Thread.sleep(random.nextLong(1000, 10_000));
                    System.out.println("task-" + task  + " is waiting...");
                    phaser.arriveAndAwaitAdvance();
                    System.out.println("task-" + task + " done Waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.awaitTermination(45, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        Phaser phaser = new Phaser(3); // 3 partisipan

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " di fase " + phaser.getPhase());
                phaser.arrive(); // Tunggu semua thread

                System.out.println(Thread.currentThread().getName() + " di fase " + phaser.getPhase());
                phaser.arrive();

                System.out.println(Thread.currentThread().getName() + " di fase " + phaser.getPhase());
                phaser.arrive();

//                phaser.
//                phaser.arriveAndDeregister(); // Keluar dari Phaser
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(phaser.getPhase());
    }
}
