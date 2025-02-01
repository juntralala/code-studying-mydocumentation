package com.ujun.lock;


import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition Interface
 * Condition merupakan alternatif lain dari monitor method (wait, notify dan notifyAll)
 * Pada Java modern saat ini, sangat disarankan menggunakan Condition dibanding monitor method
 * Condition memiliki method wait() untuk menunggu, signal() untuk mentrigger satu thread, dan signalAll() untuk mentrigger semua thread yang menunggu
 * Cara pembuatan Condition, kita bisa menggunakan method newCondition() milik Lock
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/Condition.html
 */

public class ConditionInterfaceTest {
    private String message = null;

    @Test
    public void testLockCondition() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        var thread1 = new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                lock.lock();
                message = "Muhammad Junaidi";
                condition.signal();
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
