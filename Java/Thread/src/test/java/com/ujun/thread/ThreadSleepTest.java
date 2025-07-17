package com.ujun.thread;

import org.junit.jupiter.api.Test;

/** Thread Sleep
 * Pada saat proses development, kada kita butuh melakukan simulasi proses yang berjalan dalam waktu tertentu
 * Untuk melakukan hal ini, kita bisa memanfaatkan fitur Thread Sleep yang terdapat di Java
 * Dengan menggunakan Thread Sleep, kita bisa membuat sebuah thread tertidur dan berhenti dalam waktu yang kita tentukan
 * Untuk melakukan hal ini, kita bisa memanggil static method sleep() di class Thread, maka secara otomatis Thread saat itu dimana memanggil kode sleep() akan tertidur sesuai dengan waktu milisecond yang sudah kita masukkan dalam parameter
 * Namun perlu diperhatikan, method sleep bisa menyebabkan error InterruptedException
 */

public class ThreadSleepTest {
    @Test
    public void threadSleep() throws InterruptedException {

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

        System.out.println("Thread utama selesai");

        Thread.sleep(3_000);
    }
}
