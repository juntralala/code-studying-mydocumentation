package com.juntralala.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueApp.class)
public class ValueTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    public void valueAnnotationTest() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.getAppName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertFalse(applicationProperties.isProductionMode());
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-21.0.2", applicationProperties.getJavaHome());
    }
}

@SpringBootApplication
class ValueApp {
}

@Component
@Getter
class ApplicationProperties {

    @Value("${JAVA_HOME}")
    private String javaHome;

    @Value("${application.name}")
    private String appName;

    @Value("${application.version}")
    private Integer version;

    @Value("${application.production-mode}")
    private boolean isProductionMode;

}