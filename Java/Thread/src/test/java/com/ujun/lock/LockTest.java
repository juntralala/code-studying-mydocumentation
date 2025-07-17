package com.ujun.lock;

import com.ujun.AtomicTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock Package
 * Java menyediakan high level concurrency package untuk melakukan locking atau waiting for conditions
 * Ini adalah alternatif dari low level synchronized dan manual wait dan notify
 * Untuk saat ini, sangat disarankan menggunakan package locks dibandingkan menggunakan low level synchronization sebelumnya yang sudah kita bahas
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/package-summary.html
 */

/** Lock Interface
 * Lock interface merupakan alternatif implementasi dari synchronized method dan synchronized statement
 * Untuk melakukan lock, kita bisa gunakan method lock() dan setelah selesai, kita bisa menggunakan method unlock() untuk melepaskan lock
 * Implementasi dari interface Lock adalah class ReentrantLock
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/Lock.html
 */

// lanjutannya ReadWriteLockTest

public class LockTest {

    public static class Counter {
        private Long value = 0L;
        final private Lock lock = new ReentrantLock(); // <- penggunaan salah satu class Lock

        public void increment() {
            try {
                lock.lock();
                value++;
            } finally {
                lock.unlock();
            }
        }

        public Long getValue() {
            return value;
        }
    }

    @Test
    public void test() throws InterruptedException {

        var counter = new AtomicTest.Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }

}
