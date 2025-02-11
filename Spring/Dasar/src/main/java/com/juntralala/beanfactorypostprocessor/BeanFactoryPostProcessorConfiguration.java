package com.juntralala.beanfactorypostprocessor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FooBeanFactoryPostProcessor.class
})
public class BeanFactoryPostProcessorConfiguration {
}
