package com.juntralala;

import com.juntralala.optionaldependency.OptionalConfiguration;
import com.juntralala.optionaldependency.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalDependencyInjectionTest {

    @Test
    public void testOptionalDependency() {
        ApplicationContext context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);

        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotNull(fooBar.getFoo());
        Assertions.assertNull(fooBar.getBar());
    }

}
