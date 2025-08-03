package com.juntralala.bean.change_bean_name;

import com.juntralala.bean.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChangeBeanNameConfiguration {

    @Bean(name = "fooFirst")
    public Foo foo1() {
        Foo foo = new Foo();
        return foo;
    }

    @Bean("fooSecond")
    public Foo foo2() {
        Foo foo = new Foo();
        return foo;
    }
}
