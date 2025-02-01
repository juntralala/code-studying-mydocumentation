package com.ujun.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RecursiveActionTest {

    public static class PrintForkJoinTask extends RecursiveAction {

        final private List<Integer> integers;

        public PrintForkJoinTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected void compute() {
            if (integers.size() <= 10) {
                doCompute();
            } else {
                forkCompute();
            }
        }

        private void doCompute() {
            integers.forEach((number) -> System.out.println(Thread.currentThread().getName() + ": " + number));
        }

        private void forkCompute() {
            List<Integer> integers1 = this.integers.subList(0, this.integers.size() / 2);
            List<Integer> integers2 = this.integers.subList(this.integers.size() / 2, this.integers.size());

            var task1 = new PrintForkJoinTask(integers1);
            var task2 = new PrintForkJoinTask(integers2);

            ForkJoinTask.invokeAll(task1, task2);
        }
    }

    @Test
    public void testRecursiveAction() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        var list = IntStream.range(1, 501).boxed().toList(); // boxed digunakan untuk mengubah tipe data primitive menjadi tipe reference (disini menjadi Integer)

        pool.execute(new PrintForkJoinTask(list));

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.MINUTES);
    }

}
