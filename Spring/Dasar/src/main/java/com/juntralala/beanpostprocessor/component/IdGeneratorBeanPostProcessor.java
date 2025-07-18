package com.juntralala.beanpostprocessor.component;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {

    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof IdAware) {
            IdAware idAware = (IdAware) bean;
            idAware.setId(UUID.randomUUID().toString());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
    // tidak melakukan perubahan data apa-apa disni, hanya langsung pass saja
        return bean;
    }

}
