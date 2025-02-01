package com.ujun.concurrentcollection.blockingqueue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class DelayQueueTest {

    @Test
    public void testDelayQueue() throws InterruptedException {
        var queue = new DelayQueue<ScheduledFuture<String>>();
        var executor = Executors.newScheduledThreadPool(4);

        for (int i = 0; i < 10; i++) {
            queue.put(executor.schedule(() -> "Delayed data", i, TimeUnit.SECONDS));
        }

        executor.execute(() -> {
            while (true) {
                try {
                    ScheduledFuture<String> data = queue.take();
                    System.out.println("Recieve data: " + data.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

}
