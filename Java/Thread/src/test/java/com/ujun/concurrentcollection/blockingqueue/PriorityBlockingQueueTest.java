package com.ujun.concurrentcollection.blockingqueue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

    @Test
    public void testPriotityBlockingQueue() {
        var queue = new PriorityBlockingQueue<Integer>(5);
        var executor = Executors.newFixedThreadPool(4);

        // put data
        for (int i = 0; i < 5; i++) {
            final var index = i;
            executor.execute(() -> {
                queue.put(index);
                System.out.println("Success put data: " + index);
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
