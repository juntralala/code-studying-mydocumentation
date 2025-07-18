package com.juntralala;

import com.juntralala.bean.Foo;
import com.juntralala.bean.primary_bean.PrimaryBeanConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryBeanTest {

    @Test
    void primaryBean() {
        var context = new AnnotationConfigApplicationContext(PrimaryBeanConfiguration.class);

        Foo foo = context.getBean(Foo.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertSame(foo, foo1);
        Assertions.assertNotSame(foo1, foo2);
    }

}
