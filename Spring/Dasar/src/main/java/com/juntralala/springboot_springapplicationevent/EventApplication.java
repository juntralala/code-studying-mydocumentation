package com.juntralala.springboot_springapplicationevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class EventApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EventApplication.class);
        application.setListeners(List.of(
                new AppStartingListener()
        ));

        ApplicationContext context = application.run(args);
    }
}
