package dev.juntralala.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/anonym")
    public Authentication authenticationAnonym(@CurrentSecurityContext SecurityContext securityContext) {
        return securityContext.getAuthentication();
    }
}
