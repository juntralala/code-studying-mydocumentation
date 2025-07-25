package com.juntralala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaApplication {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        SpringApplication.run(JpaApplication.class, args);
    }

}
