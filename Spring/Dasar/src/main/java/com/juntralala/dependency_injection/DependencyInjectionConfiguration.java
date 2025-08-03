package com.juntralala.dependency_injection;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfiguration {

    @Bean
    public Foo foo() {
        Foo foo = new Foo();
        return foo;
    }

    @Bean("fooSecond")
    public Foo foo2() {
        Foo foo = new Foo();
        return foo;
    }

    @Bean
    public Bar bar() {
        Bar bar = new Bar();
        return bar;
    }

    // penjelasan @Qualiafier di Memilih Dependency.md
    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar){
        FooBar fooBar = new FooBar(foo, bar);
        return fooBar;
    }

}
