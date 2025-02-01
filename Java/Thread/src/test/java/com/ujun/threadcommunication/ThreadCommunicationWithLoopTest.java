package com.ujun.threadcommunication;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationWithLoopTest {
    private String message = null;

    @Test
    public void threadCommunicationWithLoopTest() throws InterruptedException {

        var thread1 = new Thread(() -> {
            while (message == null) { // <- menungu message di assign

            }
            System.out.println(message);
        });

        var thread2 = new Thread(() -> {
            message = "Hallo, Message was assigned";
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
