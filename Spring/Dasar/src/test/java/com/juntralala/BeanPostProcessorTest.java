package com.juntralala;

import com.juntralala.beanpostprocessor.BeanPostProcessorConfiguration;
import com.juntralala.beanpostprocessor.component.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorTest {

    @Test
    public void testBeanPostProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfiguration.class);

        Car car = context.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        System.out.println(car.getId());
    }

}
