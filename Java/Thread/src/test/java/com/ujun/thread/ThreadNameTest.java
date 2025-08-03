package com.ujun.thread;

import org.junit.jupiter.api.Test;

/** Thread Name
 * Secara default thread di Java memiliki nama, ini sangat cocok untuk proses debugging ketika terjadi masalah
 * Thread name secara default akan menggunakan nama Thread-{counter}
 * Namun kita juga bisa mengubahnya dengan menggunakan method setName(name), dan getName() untuk mendapatkan nama thread nya
 */

public class ThreadNameTest {
    @Test
    public void threadName() { // ganti nama thread
        var thread = new Thread(() -> {
            System.out.println("Hello from thread: " + Thread.currentThread().getName());
        });
        thread.setName("haello");
        thread.start();
    }
}
