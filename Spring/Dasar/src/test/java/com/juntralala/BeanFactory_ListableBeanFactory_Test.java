package com.juntralala;

import com.juntralala.optionaldependencywithobjectprovider.ObjectProviderConfiguration;
import com.juntralala.optionaldependencywithobjectprovider.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class BeanFactory_ListableBeanFactory_Test {

    @Test
    public void testListableBeanFactoryUsage() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ObjectProviderConfiguration.class);

        ObjectProvider<Foo> fooObjectProvider = context.getBeanProvider(Foo.class);

        Map<String, Foo> beans = context.getBeansOfType(Foo.class);

        System.out.println(beans);
        fooObjectProvider.stream().forEach(System.out::println);
    }

}
