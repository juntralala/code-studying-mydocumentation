package com.juntralala;

import com.juntralala.import_.configurations.ImportConfiguration;
import com.juntralala.import_.data.Bar;
import com.juntralala.import_.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportConfigurationTest {

    @Test
    public void testImport() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportConfiguration.class);

        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(bar);
    }

}
