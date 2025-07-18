package com.juntralala.configurationproperties.complexconfigurationproperties.contoh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ComplexConfigurationPropertiesApp.class)
public class ComplexConfigurationPropertiesTest {

    @Autowired
    ApplicationProperties applicationProperties;

    @Test
    public void complexConfigurationProperties() {
        Assertions.assertEquals("jdbc:contoh", applicationProperties.getDatabase().getUrl());
        Assertions.assertEquals("db_contoh", applicationProperties.getDatabase().getDatabase());
        Assertions.assertEquals("root", applicationProperties.getDatabase().getUsername());
        Assertions.assertEquals("", applicationProperties.getDatabase().getPassword());
    }

}
