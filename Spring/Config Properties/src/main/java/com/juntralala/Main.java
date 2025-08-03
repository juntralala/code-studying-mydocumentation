package com.juntralala;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class);

        log.info("Data infomasi");
        System.out.println(Main.class.getResource("/banner.txt").getPath());
        System.out.println(Main.class.getResource("/"));
        System.out.println(new String(((InputStream) Main.class.getResource("/banner.txt").getContent()).readAllBytes()));
    }
}
