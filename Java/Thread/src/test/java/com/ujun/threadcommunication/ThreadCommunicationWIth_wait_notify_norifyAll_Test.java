package com.ujun.threadcommunication;


import org.junit.jupiter.api.Test;

/** Wait dan Notify
 * Menggunakan loop untuk menunggu sangat tidak direkomendasikan, alasannya buang-buang resource CPU dan juga jika terjadi interrupt, loop akan terus berjalan tanpa henti
 * Java sudah menyediakan solusi yang lebih baik dengan menambahkan method wait dan notify di java.lang.Object
 * Artinya kita bisa membuat object apapun menjadi lock, dan gunakan wait() untuk menunggu, dan gunakan notify() untuk memberitahu bahwa data sudah tersedia
 * notify() akan memberi tahu thread lain yang sedang melakukan wait() bahwa proses bisa dilanjutkan
 */

public class ThreadCommunicationWIth_wait_notify_norifyAll_Test {
    public String message = null;

    @Test
    public void threadCommunicationWithWaitNotify() throws InterruptedException {
        final Object lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Hallo, Message was assigned";
                lock.notify();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    /** Notify All
     * Kadang ada kasus dimana sebuah lock ditunggu oleh banyak thread, notify() hanya memberi sinyal kepada satu thread saja
     * Jika kita ingin mengirim sinyal ke semua thread, kita bisa menggunakan method notifyAll()
     */
    @Test
    public void withNotifyAll() throws InterruptedException {
        final Object lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Hallo, Message was assigned";
                lock.notifyAll();  // <- Jika tidak notifyAll() maka hanya salah satu thread yang menunggu message yang akan dijalankan
            }
        });

        thread1.start();
        thread3.start();
        thread2.start();

        thread1.join();
        thread3.join();
        thread2.join();
    }
}
