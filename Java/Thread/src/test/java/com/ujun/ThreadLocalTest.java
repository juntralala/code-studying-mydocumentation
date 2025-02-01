package com.ujun;


import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** ThreadLocal
 * ThreadLocal merupakan fitur di Java untuk menyimpan data
 * ThreadLocal memberi kita kemampuan untuk menyimpan data yang hanya bisa digunakan di thread tersebut
 * Tiap thread akan memiliki data yang berbeda dan tidak saling terhubung antar thread
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/ThreadLocal.html
 */

public class ThreadLocalTest {

    public static class UserService {
        private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

        public void setUser(String user) {
            threadLocal.set(user);
        }

        public void doAction() {
            String user = threadLocal.get();
            System.out.println(user + " do action");
        }

        public String getUser() {
            return threadLocal.get();
        }
    }

    @Test
    public void testThreadLocal() throws InterruptedException {
        var random = new Random();
        var userService = new UserService();
        var executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    userService.setUser("User-"+ index);
                    Thread.sleep(random.nextLong(4000));
                    userService.doAction();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
    }
}
