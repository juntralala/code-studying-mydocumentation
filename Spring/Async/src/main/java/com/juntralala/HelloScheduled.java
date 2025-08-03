package com.juntralala;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
@Component
public class HelloScheduled {

    private final AtomicLong count = new AtomicLong(0L);

    @Scheduled(timeUnit = SECONDS, fixedDelay = 2L, initialDelay = 2L)
    public void hello() {
        log.info("Hello #" + count.incrementAndGet() + " from " + Thread.currentThread());
    }

    @Scheduled(scheduler = "singleTaskScheduling", timeUnit = SECONDS, fixedDelay = 2)
    public void helloSingleScheduling() {
        log.info("Hello no increment from " + Thread.currentThread());
    }

    @Scheduled(cron = "* * * * * *")
    public void helloCron() {
        log.info("Cron: Hello");
    }

    public long getCount() {
        return this.count.get();
    }
}
