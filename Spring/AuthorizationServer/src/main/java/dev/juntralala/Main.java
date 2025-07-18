package dev.juntralala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
//@EnableWebSecurity
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .build();
//    }
}