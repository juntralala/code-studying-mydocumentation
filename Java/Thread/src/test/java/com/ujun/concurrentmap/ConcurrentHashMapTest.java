package com.ujun.concurrentmap;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTest {

    @Test
    public void testConcurrentHashMap() throws InterruptedException {
        var map = new ConcurrentHashMap<Integer, String>();
        var executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            var key = i;

            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    map.putIfAbsent(key, "Data-" + key);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            final var key = i;
            executor.execute(() -> {
                String value = map.get(key);
                System.out.println("Key: %d | Value: %s".formatted(key, value));

            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
    }

}
