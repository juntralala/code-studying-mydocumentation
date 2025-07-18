package com.juntralala.springbootapplication;

import com.juntralala.bean.Foo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FooApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FooApplication.class);
        Foo foo = context.getBean(Foo.class);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }
}
