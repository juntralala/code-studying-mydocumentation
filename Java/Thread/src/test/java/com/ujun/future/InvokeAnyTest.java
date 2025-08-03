package com.ujun.future;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** InvokeAny
 * Kadang ada kasus dimana kita ingin mengeksekusi beberapa proses secara asynchronous, namun ingin mendapatkan hasil yang paling cepat
 * Hal ini bisa dilakukan dengan menggunakan method invokeAny(Collection<Callable<T>>)
 * invokeAny() akan mengembalikan result data dari Callable yang paling cepat mengembalikan result
 */

public class InvokeAnyTest {
    @Test
    public void testInvokeAny() throws ExecutionException, InterruptedException {
        var executors = Executors.newFixedThreadPool(4);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj((operand) -> (Callable<String>) () -> {
            Thread.sleep(operand * 500L);
            return String.valueOf(operand);
        }).collect(Collectors.toList());

        String result = executors.invokeAny(callables);
        System.out.println("result = " + result);
    }
}
