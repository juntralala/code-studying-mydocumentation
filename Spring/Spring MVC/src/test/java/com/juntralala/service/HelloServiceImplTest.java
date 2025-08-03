package com.juntralala.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceImplTest {

    private HelloService helloService;

    @Autowired
    public void inject(HelloServiceImpl helloService) {
        this.helloService = helloService;
    }

    @Test
    void hello() {
        Assertions.assertEquals("Hello Guest", helloService.hello(null));
        Assertions.assertEquals("Hello ujun", helloService.hello("ujun"));
    }

}
