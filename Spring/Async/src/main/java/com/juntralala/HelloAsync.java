package com.juntralala;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
@Slf4j
public class HelloAsync {

    @Async
    @SneakyThrows
    public void hello() {
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        log.info("hello after 2 seconds {}", Thread.currentThread());
    }

    @Async("singleTaskExecutor")
    @SneakyThrows
    public Future<String> helloName(final String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        future.complete("Hello " + name + " from " + Thread.currentThread());
        log.info("Hello {} from {}", name, Thread.currentThread());
        return future;
    }
}
