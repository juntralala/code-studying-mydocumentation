package com.ujun.concurrentcollection.blockingqueue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedQueueTest {

    @Test
    public void testLinkedBlockingQueue() {
        var queue = new LinkedBlockingQueue<String>(5);
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

        // take data
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
