package com.juntralala.springboot_customizingspringapplication;

import com.juntralala.bean.Foo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringApp {
    public static void main(String[] args) {
        SpringApplication app  = new SpringApplication(MySpringApp.class);
        app.setBannerMode(Banner.Mode.OFF);

        ApplicationContext context = app.run(args);

        Foo foo = context.getBean(Foo.class);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }
}
