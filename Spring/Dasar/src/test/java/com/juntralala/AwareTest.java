package com.juntralala;

import com.juntralala.aware.AwareConfiguration;
import com.juntralala.aware.service.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareTest {

    @Test
    public void testAware() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AwareConfiguration.class);

        AuthenticationService service = context.getBean(AuthenticationService.class);

        Assertions.assertEquals(AuthenticationService.class.getName(), service.getBeanName());
        Assertions.assertEquals(context, service.getApplicationContext());
    }

}