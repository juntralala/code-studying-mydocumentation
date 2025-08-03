package com.ujun.lock;


import com.ujun.AtomicTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock
 * Kadang ada kondisi dimana kita ingin membedakan lock antara operasi update dan operasi get
 * Untuk kasus seperti ini, kita bisa membuat dua buah variable Lock
 * Namun, di Java disediakan cara yang lebih mudah, yaitu menggunakan interface ReadWriteLock
 * ReadWriteLock merupakan lock yang mendukung dua jenis operasi, read dan write
 * Implementasi dari interface ReadWriteLock adalah class ReentrantReadWriteLock
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/ReadWriteLock.html
 */

public class ReadWriteLockTest {

    public static class Counter {
        private Long value = 0L;
        final private ReadWriteLock lock = new ReentrantReadWriteLock(); // <- penggunaan ReadWriteLock

        public void increment() {
            try {
                lock.writeLock().lock();
                value++;
            } finally {
                lock.writeLock().unlock();
            }
        }

        public Long getValue() {
            try {
                lock.readLock().lock();
                return value;
            } finally {
                lock.readLock().unlock();
            }
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
