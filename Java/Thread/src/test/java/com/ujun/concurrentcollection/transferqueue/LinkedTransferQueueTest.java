package com.ujun.concurrentcollection.transferqueue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueTest {
    @Test
    public void testLinkedTransferQueue() throws InterruptedException {
        var queue = new LinkedTransferQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        // put data
        for (int i = 0; i < 10; i++) {
            int index = i;
            executor.execute(() -> {
                try {
                    queue.transfer("Data: " + index);
                    System.out.println("Success put data: " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(() -> {
            while (queue.peek() != null) {
                try {
                    var result = queue.take();
                    System.out.println(result);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
