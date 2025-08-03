package com.juntralala;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@Slf4j
@SpringBootTest
public class HelloScheduledTest {

    @Autowired
    private HelloScheduled helloScheduled;

    @Test
    @SneakyThrows
    void helloScheduled() {
        Thread.sleep(Duration.ofSeconds(5));
        log.info("helloScheduled called count: {}", this.helloScheduled.getCount());
    }
}
