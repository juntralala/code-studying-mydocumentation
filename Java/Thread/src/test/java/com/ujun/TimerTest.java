package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer
 * Timer merupakan class untuk memfasilitasi eksekusi job secara asynchronous di masa depan
 * Timer bisa di schedule untuk berjalan satu kali (delayed job), atau bisa berjalan berulang kali (repeated job)
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Timer.html
 */
public class TimerTest {
    @Test
    public void testDelayedJob() {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 2_000);
    }

    @Test
    public void testPeriodicJob() {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 2_000, 2_000); // bedanya dengan delayed job hanya pada parameter ketiga pada .schedule() method
    }
}
