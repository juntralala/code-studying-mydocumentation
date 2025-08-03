package com.juntralala;

import com.juntralala.bean.Foo;
import com.juntralala.bean.duplicate_bean.DuplicateBeanConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateBeanTest {

    @Test
    void duplicateBean() {
        var context = new AnnotationConfigApplicationContext(DuplicateBeanConfiguration.class);

        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }

    @Test
    void testErrorAccesDuplicateBeanWithoutName() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {

            var context = new AnnotationConfigApplicationContext(DuplicateBeanConfiguration.class);
            Foo foo1 = context.getBean(Foo.class);

        });
    }

}
