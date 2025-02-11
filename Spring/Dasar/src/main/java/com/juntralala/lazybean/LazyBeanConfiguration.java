package com.juntralala.lazybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Random;

@Configuration
public class LazyBeanConfiguration {

    @Lazy
    @Bean
    public Random random() {
        System.out.println("Creating Random Instance");
        return new Random();
    }

}
