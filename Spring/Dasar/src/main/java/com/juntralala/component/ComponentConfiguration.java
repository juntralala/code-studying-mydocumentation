package com.juntralala.component;

import com.juntralala.bean.BeanConfiguration;
import com.juntralala.component.with_import.AuthService;
import com.juntralala.component.with_import.CommentService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.juntralala.component.with_componentscan"
})
@Import(value = {
        AuthService.class,
        CommentService.class
})
public class ComponentConfiguration {
}
