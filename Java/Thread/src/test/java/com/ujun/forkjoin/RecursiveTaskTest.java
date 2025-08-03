package com.ujun.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class RecursiveTaskTest {

    public static class SimpleForkJoinTask extends RecursiveTask<Long> {

        final private List<Integer> integers;

        public SimpleForkJoinTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected Long compute() {
            if (integers.size() <= 10) {
                return doCompute();
            } else {
                return forkCompute();
            }
        }

        private Long doCompute() {
            return integers.stream().reduce(0, (number, accumulator) -> number + accumulator).longValue();
        }

        private Long forkCompute() {
            List<Integer> integers1 = this.integers.subList(0, this.integers.size() / 2);
            List<Integer> integers2 = this.integers.subList(this.integers.size() / 2, this.integers.size());

            var task1 = new SimpleForkJoinTask(integers1);
            var task2 = new SimpleForkJoinTask(integers2);

            ForkJoinTask.invokeAll(task1, task2);
            return task1.join() + task2.join();
        }
    }

    @Test
    public void testRecursiveAction() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        var list = IntStream.range(1, 501).boxed().toList(); // boxed digunakan untuk mengubah tipe data primitive menjadi tipe reference (disini menjadi Integer)

        ForkJoinTask<Long> task = new SimpleForkJoinTask(list);
        pool.submit(task);

        Long result = task.join();

        System.out.println("result = " + result);
        System.out.println("Manual = " + list.stream().reduce(0, (number, total) -> number + total));

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.MINUTES);
    }


}
