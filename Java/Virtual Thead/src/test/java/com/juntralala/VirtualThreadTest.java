package com.juntralala;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class VirtualThreadTest {

    @Test
    public void virtualThread() throws IOException {
        for (int i = 0; i < 10_000; i++) {
            int index = i;
            Thread.ofVirtual().start(() -> {
                System.out.println(Thread.currentThread() + ": " + index);
            });
        }

        System.in.read();
    }

    @Test
    public void builder() {
        Thread.Builder vt = Thread.ofVirtual();
    }
}
