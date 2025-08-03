package com.juntralala;

import com.juntralala.lazybean.LazyBeanConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class LazyBeanTest {

    @Test
    public void lazyBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);

        System.out.println("Bean belum dibuat");
        Random random1 = context.getBean(Random.class);
        Random random2 = context.getBean(Random.class);

        Assertions.assertNotNull(random1);
        Assertions.assertNotNull(random2);
    }

}
