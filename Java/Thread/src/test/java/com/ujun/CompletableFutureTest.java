package com.ujun;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/** Completable Future
 * Pada Java 8, terdapat sebuah class baru bernama CompletableFuture, ini merupakan implementasi Future yang bisa kita set datanya secara manual
 * CompletableFuture sangat cocok ketika kita misal perlu membuat future secara manual, sehingga kita tidak memerlukan Callable
 * Untuk memberi value terhadap CompletableFuture secara manual, kita bisa menggunakan method complete(value) atau completeExceptionally(error) untuk error
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CompletableFuture.html
 */

public class CompletableFutureTest {

    private static ExecutorService executors;
    private static Random random;

    @BeforeAll
    public static void setUp() {
        executors = Executors.newCachedThreadPool();
        random = new Random();
    }

    // <[]=========START cara1 START=========[]>

    public Future<String> getFutureValue() {
        CompletableFuture<String> future = new CompletableFuture<>();

        executors.execute(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Hi");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    @Test
    public void testCreate() throws InterruptedException, ExecutionException {
        Future<String> future = this.getFutureValue();
        System.out.println(future.get());
    }

    // <[]=========END cara1 END=========[]>

    // {=============START cara2 START=============}
    private void execute(CompletableFuture<String> future, String value) {
        executors.execute(() -> {
            try {
                Thread.sleep(random.nextLong(1000, 5000));
                future.complete(value);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
    }


    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();

        this.execute(future, "Pertama");
        this.execute(future, "Kedua");
        this.execute(future, "Ketiga");

        return future;
    }

    @Test
    public void testFastest() throws InterruptedException, ExecutionException {
        Future<String> future = this.getFastest();
        System.out.println(future.get());
    }

    // {=============END cara2 END=============}
}
