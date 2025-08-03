package com.juntralala.testpropertysource;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@TestPropertySources({
        @TestPropertySource("classpath:/test.properties")
})
@SpringBootTest(classes = PropertySourceApp.class)
public class TestPropertySourceTest {

    @Autowired
    private SampleProperties sampleProperties;

    @Test
    public void testPropertySource() {
        Assertions.assertEquals("Project Test", sampleProperties.getSampleName());
        Assertions.assertEquals(1, sampleProperties.getSampleVersion());
    }

}


@SpringBootApplication
class PropertySourceApp {
}

@Component
@Getter
class SampleProperties {

    @Value("${sample.name}")
    private String sampleName;

    @Value("${sample.version}")
    private int sampleVersion;

}