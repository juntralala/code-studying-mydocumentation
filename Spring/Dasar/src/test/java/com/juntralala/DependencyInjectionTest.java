package com.juntralala;

import com.juntralala.dependency_injection.Bar;
import com.juntralala.dependency_injection.DependencyInjectionConfiguration;
import com.juntralala.dependency_injection.Foo;
import com.juntralala.dependency_injection.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

    @Test
    void dependencyInjection() {
        var context = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
        FooBar fooBar = context.getBean(FooBar.class);
        Assertions.assertNotNull(fooBar);
    }

    @Test
    void withputDependencyInjection() {
        Foo foo = new Foo();
        Bar bar = new Bar();
        FooBar fooBar = new FooBar(foo, bar);

        Assertions.assertNotNull(fooBar);
    }
}
