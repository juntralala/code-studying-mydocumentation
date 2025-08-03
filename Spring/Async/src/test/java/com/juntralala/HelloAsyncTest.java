package com.juntralala;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Future;

@SpringBootTest
@Slf4j
public class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void helloAsync() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            this.helloAsync.hello();
        }
        log.info("After call all hello async");
        Thread.sleep(Duration.ofSeconds(10).toMillis());
    }

    @Test
    @SneakyThrows
    void helloNameAsync() throws InterruptedException {
        Future<String> helloFuture = helloAsync.helloName("Ujun");
        log.info("After Call Hello Name");
        String hello = helloFuture.get();
    }

}
