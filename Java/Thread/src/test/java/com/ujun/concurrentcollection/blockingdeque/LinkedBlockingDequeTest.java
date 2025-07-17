package com.ujun.concurrentcollection.blockingdeque;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeTest {

    @Test
    public void testLinkedBlockingDeque() throws InterruptedException {
        var queue = new LinkedBlockingDeque<String>(10);
        var executor = Executors.newFixedThreadPool(20);

        // put data
        for (int i = 0; i < 10; i++) {
            int index = i;
            executor.execute(() -> {
                try {
                    queue.put("Data: " + index);
                    System.out.println("Success put data: " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        Thread.sleep(10);

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
