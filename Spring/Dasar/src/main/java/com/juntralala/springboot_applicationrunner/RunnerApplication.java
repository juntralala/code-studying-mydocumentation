package com.juntralala.springboot_applicationrunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RunnerApplication {

    @Slf4j
    @Component
    public static class SimpleRunner implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) {
            List<String> profiles = args.getOptionValues("profiles"); // coba gunakan parameter --profiles saat menjalankan applikasi
            log.info("Profiles: {}", profiles);
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }
}
