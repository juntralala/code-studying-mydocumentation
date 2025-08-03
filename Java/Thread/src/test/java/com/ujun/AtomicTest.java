package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {

    public static class Counter {
        private final AtomicLong value = new AtomicLong(); // <- Penggunaan salah satu Atomic Class

        public void increment() {
            value.set(2);
            value.getAndIncrement();
        }

        public long getValue() {
            return value.get();
        }
    }

    @Test
    public void testAtomic() throws InterruptedException {
        var counter = new Counter();
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
