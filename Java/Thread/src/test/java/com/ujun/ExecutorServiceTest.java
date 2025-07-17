package com.ujun;


/** ExecutorService
 * Jika kita perhatikan, ThreadPoolExecutor merupakan implementasi dari interface Executor dan ExecutorService
 * Jadi saat kita membuat ThreadPoolExecutor sebenarnya kita membuat Executor Service
 * Dan sebenarnya pembuatan Threadpool secara manual jarang dilakukan, kecuali pada kasus kita benar-benar butuh melakukan tuning Threadpool
 * Namun dalam kebanyakan kasus, kita jarang sekali membuat Threadpool secara manual
 * Rata-rata, biasanya untuk mengeksekusi Runnable, biasanya kita akan menggunakan Executor Service
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ExecutorService.html
 */

/** Executors
 * Karena ExecutorService adalah interface, jadi pembuatan object ExecutorService salah satu nya adalah menggunakan ThreadPoolExecutor
 * Namun ada yang lebih mudah, yaitu menggunakan class Executors
 * Executor merupakan class utility untuk membantu kita membuat object ExecutorService secara mudah
 * Sebenarnya implementasi Executors pun menggunakan ThreadPoolExecutor, hanya saja kita tidak perlu terlalu pusing melakukan pengaturan threadpool secara manual
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/Executors.html
 */

/** Executors Methods
 * | Executors Static Method    | Keterangan                                                                |
 * |----------------------------|---------------------------------------------------------------------------|
 * | newFixedThreadPool(n)      | Membuat threadpool dengan jumlah pool min dan max fix                     |
 * | newSingleThreadExecutor()  | Membuat threadpool dengan jumlah pool min dan max 1                       |
 * | newCachedThreadPool()      | Membuat threadpool dengan jumlah thread bisa bertambah tidak terhingga    |
 */

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Queue dari Executors (WARNING)
 * Hati-hati ketika membuat ExecutorService menggunakan Executors class
 * Karena rata-rata Threadpool yang dibuat memiliki kapasitas queue tidak terbatas
 * Artinya jika terlalu banyak Runnable task di dalam queue, maka memori penyimpanan yang akan terpakai akan semakin besar
 */

public class ExecutorServiceTest {
    @Test
    public void createWithExecutors() {
        ExecutorService executors = Executors.newSingleThreadExecutor();
//        ExecutorService executors = Executors.newFixedThreadPool(8);
//        ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executors.execute(() -> {
                try {
                    Thread.sleep(250);
                    System.out.println("Execute");
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        executors.shutdown();
        executors.close();
    }
}
