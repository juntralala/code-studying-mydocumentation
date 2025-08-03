package com.juntralala.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }

    public String bye(String name) {
        return "Bye " + name;
    }

}
