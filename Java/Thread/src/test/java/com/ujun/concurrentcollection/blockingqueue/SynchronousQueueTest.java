package com.ujun.concurrentcollection.blockingqueue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    @Test
    public void testSynchronousQueue() {
        var queue = new SynchronousQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data"); // <- Harus menunggu proses put yang lain selesai jika ada thread lain yang melakukan put
                    System.out.println("Success Put data");
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
