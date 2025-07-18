package com.juntralala;

import com.juntralala.constructor_based_dependencyinjection.ConstructorbasedDependencyInjectionConfiguration;
import com.juntralala.constructor_based_dependencyinjection.components.ProductRepository;
import com.juntralala.constructor_based_dependencyinjection.components.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorbasedDependencyInjectionTest {

    @Test
    public void testConstructorBasedDependencyInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConstructorbasedDependencyInjectionConfiguration.class);

        ProductService productService = context.getBean(ProductService.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

}
