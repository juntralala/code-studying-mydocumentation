package com.juntralala.propertysource;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = {PropertySourceApp.class})
public class PropertySourceTest {

    @Autowired
    private SampleProperties sampleProperties;

    @Test
    public void testPropertySource() {
        Assertions.assertEquals("Contoh Tambahan dari Application Properties", sampleProperties.getSampleName());
        Assertions.assertEquals(1, sampleProperties.getSampleVersion());
        Assertions.assertEquals("Belajar Spring Boot", sampleProperties.getAppName());
        Assertions.assertEquals(1, sampleProperties.getSampleVersion());
    }

}

@SpringBootApplication
@PropertySources({@PropertySource("classpath:/sample.properties")})
class PropertySourceApp {
}

@Component
@Getter
class SampleProperties {

    @Value("${sample.name}")
    private String sampleName;

    @Value("${sample.version}")
    private int sampleVersion;

    @Value("${application.name}")
    private String appName;

    @Value("${application.version}")
    private int appVersion;

}
