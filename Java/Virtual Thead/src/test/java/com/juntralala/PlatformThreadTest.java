package com.juntralala;

import org.junit.jupiter.api.Test;


/**
 * Platform Thread ya thread biasa, seperti yang pernah dipelajari sebelumnya
 */

public class PlatformThreadTest {

    @Test
    public void platFormThread() {
        for (int i = 0; i < 10_000; i++) {
            int index = i;
            Thread.ofPlatform().daemon(false).start(() -> {
                System.out.println(Thread.currentThread() + ": " + index);
            });
        }
    }

}
