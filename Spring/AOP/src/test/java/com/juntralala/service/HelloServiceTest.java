package com.juntralala.service;

import com.juntralala.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Main.class)
public class HelloServiceTest {

    private HelloService helloService;

    @Autowired
    public void inject(HelloService helloService) {
        this.helloService = helloService;
    }

    @Test
    public void helloService() {
        Assertions.assertEquals("Hello ujun", helloService.hello("ujun"));
        Assertions.assertEquals("Bye ujun", helloService.bye("ujun"));
    }

}
