package com.juntralala.resourceloader;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@SpringBootTest(classes = TestApplication.class)
public class ResourceLoaderTest {

    @Autowired
    private SampleResource sampleResource;

    @Test
    public void testResourceLoader() throws IOException {
        Assertions.assertEquals("Hello World", sampleResource.getProperties());
    }
}

@SpringBootApplication
class TestApplication {
}

@Component
class SampleResource implements ResourceLoaderAware {

    @Setter
    private ResourceLoader resourceLoader;

    public String getProperties() throws IOException {
        Resource resource = this.resourceLoader.getResource("classpath:/text/resource.txt");
        try (var inputStream = resource.getInputStream()) {
            return new String(inputStream.readAllBytes());
        }
    }
}
