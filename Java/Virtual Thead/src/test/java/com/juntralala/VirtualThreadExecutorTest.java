package com.juntralala;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadExecutorTest {

    @Test
    public void virtualThreadExecutor() throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 1_000_000; i++) {
            int index = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread() + ": " + index + " " + Thread.currentThread().threadId());
            });
        }

        System.out.println("Selesai");
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.MINUTES);
    }

    native void p();
}
