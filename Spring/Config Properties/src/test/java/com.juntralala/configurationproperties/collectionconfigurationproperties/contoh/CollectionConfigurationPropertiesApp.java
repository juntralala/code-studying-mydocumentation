package com.juntralala.configurationproperties.collectionconfigurationproperties.contoh;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ApplicationProperties.class
})
public class CollectionConfigurationPropertiesApp {
}
