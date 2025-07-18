package com.juntralala.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;

    @Autowired
    public void inject(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    public void helloGuest() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
        String response = responseEntity.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Guest", response);
    }

    @Test
    public void helloName() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=ujun", String.class);
        String response = responseEntity.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello ujun", response);
    }

}
