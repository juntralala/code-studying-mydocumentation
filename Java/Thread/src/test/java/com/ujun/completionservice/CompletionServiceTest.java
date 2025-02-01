package com.ujun.completionservice;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Completion Service
 * CompletionService merupakan sebuah interface yang digunakan untuk memisahkan antara bagian yang mengeksekusi
   asynchronous task dan yang menerima hasil dari task yang sudah selesai
 * Kadang ada kebutuhan misal kita butuh menjalankan sesuatu secara parallel, lalu ada satu thread yang melakukan
 * eksekusi task dan satu thread menunggu hasil nya
 * Kita bisa menggunakan CompletionService untuk melakukan itu
 * Implementasi interface CompletionService adalah class ExecutorCompletionService
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CompletionService.html
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ExecutorCompletionService.html
 */

public class CompletionServiceTest {

    private final Random random = new Random();


    @Test
    public void test() throws InterruptedException {

        ExecutorService excutors = Executors.newFixedThreadPool(16);
        CompletionService<String> service = new ExecutorCompletionService<>(excutors); // <- pembuatan executor service

        // submit task
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var task = i;
                service.submit(() -> {
                    Thread.sleep(random.nextLong(2000));
                    return "Task-" + task;
                });
            }
        });

        // poll task
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    Future<String> future = service.poll(5, TimeUnit.SECONDS);
                    if (future == null){
                        break;
                    } else {
                        System.out.println(future.get());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    break;
                }
            }
        });

        excutors.awaitTermination(30, TimeUnit.MINUTES);
        excutors.shutdown();
    }
}
