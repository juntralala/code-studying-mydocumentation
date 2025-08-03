package com.juntralala.dependson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependOnConfiguration {

    @Bean
    @DependsOn(value = {"bar"}) // <- bar akan lebih dulu dibuat
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

}
