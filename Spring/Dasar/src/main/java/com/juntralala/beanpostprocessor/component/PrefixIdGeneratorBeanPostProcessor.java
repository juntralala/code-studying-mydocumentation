package com.juntralala.beanpostprocessor.component;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class PrefixIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {

    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if(bean instanceof IdAware) {
            IdAware idAware = (IdAware) bean;
            idAware.setId("OZON-" + idAware.getId());
        }
        return bean;
    }

}
