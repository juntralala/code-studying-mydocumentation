package com.juntralala.configurationproperties.collectionconfigurationproperties.contoh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Map;

@SpringBootTest(classes = CollectionConfigurationPropertiesApp.class)
public class CollectionConfigurationPropertiesTest {

    @Autowired
    ApplicationProperties properties;

    @Test
    public void collectionConfigurationProperties() {
        Assertions.assertEquals(
                Arrays.asList("products", "customers", "categories"),
                properties.getDatabase().getWhitelistTables());

        Map<String, Integer> maxTablesSize = properties.getDatabase().getMaxTablesSize();
        Assertions.assertEquals(100, maxTablesSize.get("products"));
        Assertions.assertEquals(100, maxTablesSize.get("categories"));
        Assertions.assertEquals(100, maxTablesSize.get("customers"));
    }

    @Test
    public void emmbeddedCollection() {
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", properties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role",  properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role",  properties.getRoles().get("finance").getName());
    }

}
