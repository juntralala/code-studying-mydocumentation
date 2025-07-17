package com.ujun.synchronization;

import org.junit.jupiter.api.Test;

/** Synchronized Statement
 * Saat kita menggunakan synchronized method, secara otomatis seluruh method akan ter synchronization
 * Kadang, misal kita hanya ingin melakukan synchronized pada bagian kode tertentu saja
 * Untuk melakukan hal tersebut, kita bisa menggunakan synchronized statement
 * Namun ketika kita menggunakan synchronized statement, kita harus menentukan object intrinsic lock sendiri
 */
public class SysnchronizedStatementTest {

    static class Counter {
        private Long value = 0L;

        public void increment() { // didalam method ini menggunakan sync statement
            synchronized (this) {
                this.value++;
            }
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
