package com.ujun.thread;

import org.junit.jupiter.api.Test;

/** Thread
 * Di Java, implementasi Concurrency dan Parallel dapat menggunakan Thread
 * Thread direpresentasikan oleh class bernama Thread di package java.lang
 */

/** Main Thread
 * Secara default, saat sebuah aplikasi Java berjalan, minimal akan ada satu thread yang berjalan
 * Dalam aplikasi Java biasa, biasanya kode program kita akan berjalan di dalam thread yang bernama main
 * Bahkan di Unit Test pun, memiliki thread sendiri
 */

/** Membuat Thread
 * Thread merupakan proses ringan, membuat Thread bukan berarti kita melakukan pekerjaan
 * Untuk membuat pekerjaan, kita perlu membuat object dari interface Runnable, selanjutnya object Runnable tersebut bisa kita berikan ke Thread untuk dijalankan
 * Saat Thread berjalan, dia akan berjalan secara asynchronous, artinya dia akan berjalan sendiri, dan kode program kita akan berlanjut ke kode program selanjutnya
 * Untuk menjalankan Thread, kita bisa memanggil function start() milik Thread
 */

public class ThreadTest {
    @Test
    public void mainThread() {
        Thread currentThread = Thread.currentThread();

        System.out.println(currentThread.getName());
    }

    @Test
    public void createThread() {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Hello from thread : " + Thread.currentThread().getName());
    }
}
