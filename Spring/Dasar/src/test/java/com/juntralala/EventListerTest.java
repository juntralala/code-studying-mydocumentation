package com.juntralala;

import com.juntralala.eventlistener.EventListenerConfiguration;
import com.juntralala.eventlistener.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventListerTest {

    @Test
    public void testEventListener() {
        ApplicationContext context = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
        UserService service = context.getBean(UserService.class);

        boolean isSuccesss1  = service.login("ujun", "rahasia");
        boolean isSuccesss2  = service.login("ujun", "salah");
        boolean isSuccesss3  = service.login("ozon", "rahasia");

        Assertions.assertTrue(isSuccesss1);
        Assertions.assertFalse(isSuccesss2);
        Assertions.assertFalse(isSuccesss3);
    }

}
