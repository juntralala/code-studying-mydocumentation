package com.juntralala;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class AsyncConfiguration {

    @Bean
    public Executor taskExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    @Bean
    public Executor singleTaskExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Bean
    public ScheduledExecutorService taskScheduling() {
        return Executors.newScheduledThreadPool(2);
    }

    @Bean
    public ScheduledExecutorService singleTaskScheduling() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
