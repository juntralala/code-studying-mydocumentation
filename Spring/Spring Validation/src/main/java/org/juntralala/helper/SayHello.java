package org.juntralala.helper;

import org.springframework.stereotype.Component;

@Component
public class SayHello implements ISayHello {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
