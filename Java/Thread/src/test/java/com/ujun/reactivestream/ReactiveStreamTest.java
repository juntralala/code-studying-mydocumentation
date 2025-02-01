package com.ujun.reactivestream;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ReactiveStreamTest {

    public static class PrintSubscriber implements Flow.Subscriber<String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            try {
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " resieve: " + item);
                this.subscription.request(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onError(Throwable e) {
            throw (RuntimeException) e;
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + " is DONE");
        }
    }

    public static class HelloProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println(Thread.currentThread().getName());
            this.submit("Hello " + item);
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable e) {
            throw (RuntimeException) e;
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + " is DONE");
        }
    }

    // untuk publisher kita tidak perlu implementasi sendiri karna sudah ada, tidak seperti Subscriber
    @Test
    public void testReactiveStream() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        PrintSubscriber subscriber = new PrintSubscriber();
        publisher.subscribe(subscriber);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("Ujun: " + i);
                System.out.println("Send Ujun: " + i);
            }
        });

//        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
    }

    /**
     * Penjelasan Buffer ada di Buffer.md
     */
    @Test
    public void customBufferSize() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        var forkJoinPool = Executors.newWorkStealingPool();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>(forkJoinPool, 5);

        PrintSubscriber subscriber1 = new PrintSubscriber();
        PrintSubscriber subscriber2 = new PrintSubscriber();

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("Ujun: " + i);
                System.out.println("Send Ujun: " + i);
            }
            publisher.close();
        });

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
        ExecutorService executor1 = (ExecutorService) publisher.getExecutor();
        executor1.shutdown();
        executor1.awaitTermination(2, TimeUnit.MINUTES);
    }

    @Test
    public void testWithProcessor() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        PrintSubscriber subscriber = new PrintSubscriber();
        HelloProcessor processor = new HelloProcessor();

        publisher.subscribe(processor);
        processor.subscribe(subscriber);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("Ujun-" + i);
                System.out.println("Send: Ujun-" + i);
            }
        });

//        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
    }
}
