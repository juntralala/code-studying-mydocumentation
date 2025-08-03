package com.juntralala.profilepropertiesfile;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestApp.class)
@ActiveProfiles({"local", "production"})
public class ProfilePropertiesFileTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    public void differentAppProfileDependsOnActiveProfile() {
        Assertions.assertEquals("Default", applicationProperties.getDefaultFile());
        Assertions.assertEquals("Production", applicationProperties.getProductionFile());
        Assertions.assertEquals("Local", applicationProperties.getLocalFile());
    }

}

// app
@SpringBootApplication
class TestApp {
}

@Component
@Getter
class ApplicationProperties {

    @Value("${profile.default}")
    private String defaultFile;

    @Value("${profile.production}")
    private String productionFile;

    @Value("${profile.local}")
    private String localFile;

}


