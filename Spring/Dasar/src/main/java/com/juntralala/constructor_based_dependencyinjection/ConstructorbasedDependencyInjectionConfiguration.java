package com.juntralala.constructor_based_dependencyinjection;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.juntralala.constructor_based_dependencyinjection.components"
})
public class ConstructorbasedDependencyInjectionConfiguration {
}
