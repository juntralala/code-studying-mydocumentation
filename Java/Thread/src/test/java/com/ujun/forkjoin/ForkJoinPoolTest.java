package com.ujun.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {
    @Test
    public void createForkJoinPool() {
        ForkJoinPool pool1 = ForkJoinPool.commonPool(); // <- jumlah parallelism sesuai jumlah cpu
        ForkJoinPool pool2 = new ForkJoinPool(4); // <- atur sendiri

        ExecutorService service1 = Executors.newWorkStealingPool(); // total cpu core parallelism
        ExecutorService service2 = Executors.newWorkStealingPool(4);
    }
}
