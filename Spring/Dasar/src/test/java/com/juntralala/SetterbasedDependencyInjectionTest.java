package com.juntralala;

import com.juntralala.setter_based_dependencyinjection.SetterbasedDependencyInjectionConfiguration;
import com.juntralala.setter_based_dependencyinjection.service.CategoryRepository;
import com.juntralala.setter_based_dependencyinjection.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetterbasedDependencyInjectionTest {

    @Test
    public void setterBasedDependencyInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SetterbasedDependencyInjectionConfiguration.class);

        CategoryService categoryService = context.getBean(CategoryService.class);

        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

}
