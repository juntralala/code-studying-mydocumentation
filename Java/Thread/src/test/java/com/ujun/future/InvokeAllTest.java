package com.ujun.future;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Invoke All
 * ExecutorService memiliki method bernama  invokeAll(Collection<Callable<T>>) untuk mengeksekusi banyak Callable secara sekaligus
 * Ini cocok ketika ada kasus kita ingin menjalankan proses asynchronous secara parallel sebanyak jumlah thread di threadpool
 * Hal ini bisa mempercepat proses dibanding kita eksekusi satu persatu
 */

public class InvokeAllTest {
    @Test
    public void testInvokeAll() throws InterruptedException, ExecutionException {
        var executors = Executors.newFixedThreadPool(4);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj((operand) -> (Callable<String>) () -> {
            Thread.sleep(operand * 500L);
            return String.valueOf(operand);
        }).collect(Collectors.toList());

        List<Future<String>> futures = executors.invokeAll(callables);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }
}
