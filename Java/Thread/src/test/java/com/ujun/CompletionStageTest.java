package com.ujun;


// Lanjutan dari CompletableFutureTest

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/** Completion Stage
 * CompletableFuture merupakan turunan dari interface CompletionStage
 * CompletionStage merupakan fitur dimana kita bisa menambahkan asynchronous computation, tanpa harus menunggu dulu data dari Future nya ada
 * CompletionStage sangat mirip dengan operation di Java Stream, hanya saja tidak sekomplit di Java Stream
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CompletionStage.html
 */

public class CompletionStageTest {

    private static ExecutorService executors = Executors.newSingleThreadExecutor();

    public CompletableFuture<String> getFutureValue() {
        CompletableFuture<String> future = new CompletableFuture<>();

        executors.execute(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Muhammad Junaidi 123");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    @Test
    public void testCompletionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = getFutureValue();

        CompletableFuture<String[]> future2 = future.thenApply(String::toUpperCase)
                .thenApply(value -> value.split(" "));

        for (String value : future2.get()) {
            System.out.println(value);
        }
    }
}
