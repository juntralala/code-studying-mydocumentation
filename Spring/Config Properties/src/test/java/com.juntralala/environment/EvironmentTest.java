package com.juntralala.environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironementApp.class)
public class EvironmentTest {

    @Autowired
    private Environment environment;

    @Test
    public void getVariableEnvValue() {
        String javaHome = environment.getProperty("JAVA_HOME");

        System.out.println("javaHome = " + javaHome);
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-21.0.2", javaHome);
    }

}

@SpringBootApplication
class EnvironementApp {
}
