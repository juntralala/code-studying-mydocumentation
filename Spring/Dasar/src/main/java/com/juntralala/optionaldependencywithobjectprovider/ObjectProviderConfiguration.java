package com.juntralala.optionaldependencywithobjectprovider;

import com.juntralala.optionaldependencywithobjectprovider.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({
        "com.juntralala.optionaldependencywithobjectprovider.data"
})
public class ObjectProviderConfiguration {

    // yang ketiga berasal dari @Component

    @Bean
    @Primary
    public Foo foo1() {
        return new Foo();
    }

    @Bean
    public Foo foo2() {
        return new Foo();
    }
}
