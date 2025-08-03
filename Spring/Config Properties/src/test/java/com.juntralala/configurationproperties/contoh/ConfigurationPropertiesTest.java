package com.juntralala.configurationproperties.contoh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = ConfigurationPropertiesApp.class)
public class ConfigurationPropertiesTest {

    @Autowired
    ApplicationProperties applicationProperties;
    @Autowired
    Environment environment;

    @Test
    public void testConfigurationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertFalse(applicationProperties.isProductionMode());
    }

}
