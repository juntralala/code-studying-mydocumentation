package com.juntralala.setter_based_dependencyinjection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.juntralala.setter_based_dependencyinjection.service"
})
public class SetterbasedDependencyInjectionConfiguration {
}
