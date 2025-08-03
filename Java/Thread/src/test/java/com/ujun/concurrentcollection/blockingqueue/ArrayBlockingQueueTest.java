package com.ujun.concurrentcollection.blockingqueue;


import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;

// penjelasan method-method nya ada di BlockingQueue.md

public class ArrayBlockingQueueTest {

    @Test
    public void testArrayBlockingQueue() {
        var queue = new ArrayBlockingQueue<String>(5);
        var executor = Executors.newFixedThreadPool(4);

        // put data
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Success put data");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // salah satu contoh mengambil data
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    var result = queue.take();
                    System.out.println(result);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }


}
