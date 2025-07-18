package com.juntralala;

import com.juntralala.dependency_injection.Bar;
import com.juntralala.dependency_injection.DependencyInjectionConfiguration;
import com.juntralala.dependency_injection.Foo;
import com.juntralala.dependency_injection.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjection_SelectDependencyTest {

    @Test
    void selectDependency() {
        var context = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);

        Foo foo = context.getBean("fooSecond", Foo.class);
        Bar bar = context.getBean(Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotNull(fooBar);
        Assertions.assertEquals(foo, fooBar.getFoo());
        Assertions.assertEquals(bar, fooBar.getBar());
    }

}
