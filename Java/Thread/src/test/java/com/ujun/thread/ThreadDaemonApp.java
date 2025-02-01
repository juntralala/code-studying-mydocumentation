package com.ujun.thread;

/** Daemon
 * Secara default thread di Java memiliki nama, ini sangat cocok untuk proses debugging ketika terjadi masalah
 * Thread name secara default akan menggunakan nama Thread-{counter}
 * Namun kita juga bisa mengubahnya dengan menggunakan method setName(name), dan getName() untuk mendapatkan nama thread nya
 */

public class ThreadDaemonApp {
    public static void main(String[] args) {
        var thread = new Thread(() -> {
            try {
                System.out.println("Run Thread");
                Thread.sleep(5_000);
                System.out.println("Thread done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true); // <- aktifkan dan noaktifkan daemon
        thread.start();
        System.out.println("Program selesai");
    }
}
