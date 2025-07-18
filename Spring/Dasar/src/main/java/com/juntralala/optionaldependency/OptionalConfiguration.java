package com.juntralala.optionaldependency;

import com.juntralala.optionaldependency.data.Bar;
import com.juntralala.optionaldependency.data.Foo;
import com.juntralala.optionaldependency.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/*
hanya menyediakan Bean Foo, tidak ada bar, maka Bar akan Optional<Bar> akan diinject nilai null saja (tidak error)
 */

@Configuration
public class OptionalConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar) {
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
