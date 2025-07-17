package com.ujun.synchronization;

import org.junit.jupiter.api.Test;

/** Synchronized Method
 * Di Java, terdapat dua jenis synchronization, yaitu synchronized method dan synchronized statement
 * Synchronized method merupakan cara synchronization paling mudah, karena kita hanya perlu menambah kata
   kunci synchronized pada method yang ingin kita set sebagai synchronization
 * Dengan begitu, secara otomatis method tersebut hanya bisa diakses oleh satu thread pada satu waktu
 */

public class SynchronizedMethodTest {
    static class Counter {
        private long value = 0L;

        public synchronized void increment() { // <- ini yang dimaksud  synchronized method
            this.value++;
        }

        public long getValue() {
            return this.value;
        }
    }

    @Test
    public void synchronizedMethod() throws InterruptedException {
        var counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
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

        System.out.println();

        System.out.println(counter.getValue());
    }
}
