package com.juntralala.beanpostprocessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.juntralala.beanpostprocessor.component"
})
public class BeanPostProcessorConfiguration {
}
