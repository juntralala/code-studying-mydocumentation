package com.ujun.parallelstream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Custom ForkJoinPool
 * Method parallel() di Java Stream tidak memiliki parameter ForkJoinPool sama sekali, lantas bagaimana jika kita ingin
 * menggunakan ForkJoinPool yang kita buat?
 * Kita bisa mengeksekusi parallel stream nya dalam task nya ForkJoinPool
 */

public class CustomForkJoinPoolTest {
    @Test
    @DisplayName("CustomForkJoinPool untuk menjalankan Parallel Stream")
    public void customForkJoinPool() {
        var pool = new ForkJoinPool(2);
        Stream<Integer> stream = IntStream.range(1, 1001).boxed();

        ForkJoinTask<?> task = pool.submit(() -> {
            stream.parallel().forEach((number) -> System.out.println(Thread.currentThread().getName() + ": " + number));
        });

        task.join();
    }
}
