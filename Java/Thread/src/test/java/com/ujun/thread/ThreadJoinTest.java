package com.ujun.thread;

import org.junit.jupiter.api.Test;

/** Thread Join
 * Kadang kita ingin menunggu sampai sebuah thread selesai tugasnya
 * Untuk melakukan hal tersebut, kita bisa memanggil method join milik thread yang akan kita tunggu
 */

public class ThreadJoinTest {
    @Test
    public void threadJoin() throws InterruptedException {

        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();


        System.out.println("Menunggu selesai");
        thread.join();  // menunggu thread itu selesai baru thread utama dilanjutkan

        System.out.println("Program selesai");
    }
}
