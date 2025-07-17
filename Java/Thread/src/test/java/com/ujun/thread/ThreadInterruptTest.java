package com.ujun.thread;

import org.junit.jupiter.api.Test;

/** Thread Interrupt
 * Interrupt merupakan mengirim sinyal ke thread bahwa thread tersebut harus berhenti melakukan pekerjaannya saat ini
 * Untuk melakukan interrupt, kita bisa menggunakan method interrupt() pada thread
 * Saat kita memanggil method interrupt(), secara otomatis Thread.interrupted() akan bernilai true
 * Perlu diingat, kode program kita pada Runnable harus melakukan pengecekan interrupted, jika tidak, sinyal interrupt tidak ada gunanya
 */

public class ThreadInterruptTest {
    @Test
    public void threadInterruptIncorrect() throws InterruptedException {
        var thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000); // jika terjadi interrupt, kode tidak dibreak atau dihentikan sehingga thread ini tetap jalan
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("Menunggu selesai");
    }

    @Test
    public void threadInterruptCorrectWithReturn() throws InterruptedException {
        var thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        });

        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("Menunggu selesai");
    }

    @Test
    public void threadInterruptCorrectWithBreakLoop() throws InterruptedException {
        var thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("Menunggu selesai");
    }

    @Test
    public void threadInterruptCorrectWithIf() throws InterruptedException {
        // Thread.sleep() memiliki kemampuan untuk memeriksa kondisi jika diinterupsi
        // namun biasanya kita tidak menggunakan Thread.sleep() saat pakai Thread
        var thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (Thread.interrupted()) {
                    return;
                }
                System.out.println("Runnable : " + i);

                try {
                Thread.sleep(1_000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("Menunggu selesai");
    }
}
