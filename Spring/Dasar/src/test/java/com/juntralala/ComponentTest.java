package com.juntralala;

import com.juntralala.component.ComponentConfiguration;
import com.juntralala.component.with_componentscan.ProductService;
import com.juntralala.component.with_import.AuthService;
import com.juntralala.component.with_import.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    @Test
    public void testComponent() {
        ApplicationContext app = new AnnotationConfigApplicationContext(ComponentConfiguration.class);

        ProductService productService = app.getBean(ProductService.class);
        CommentService commentService = app.getBean(CommentService.class);
        AuthService authService = app.getBean(AuthService.class);

        Assertions.assertNotNull(productService);
        Assertions.assertNotNull(commentService);
        Assertions.assertNotNull(authService);
    }

}
