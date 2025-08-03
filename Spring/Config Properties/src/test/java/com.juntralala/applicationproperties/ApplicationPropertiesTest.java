package com.juntralala.applicationproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = {ApplicationPropertiesApp.class})
public class ApplicationPropertiesTest {

    @Autowired
    private Environment environment;

    @Test
    public void accessApplicationDotProperties() {
        String springName = environment.getProperty("application.name");

        Assertions.assertEquals("Belajar Spring Boot", springName);
    }

}

@SpringBootApplication
class ApplicationPropertiesApp {
}
