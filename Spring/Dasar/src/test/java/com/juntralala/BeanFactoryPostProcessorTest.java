package com.juntralala;

import com.juntralala.beanfactorypostprocessor.BeanFactoryPostProcessorConfiguration;
import com.juntralala.beanfactorypostprocessor.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfiguration.class);

        Foo foo = context.getBean(Foo.class);

        Assertions.assertNotNull(foo);
    }

}
