package com.juntralala.resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {

    @Test
    public void createResource() throws IOException {
        var resource = new ClassPathResource("/text/resource.txt");

        Assertions.assertNotNull(resource);

        System.out.println(resource.getPath());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile().getAbsolutePath());
    }

}
