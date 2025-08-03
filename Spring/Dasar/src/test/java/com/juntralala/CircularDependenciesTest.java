package com.juntralala;

import com.juntralala.dependency_injection.problem_circular_dependency.CircularDependenciesConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependenciesTest {

    @Test
    public void circularDependencies() {
        Assertions.assertThrows(BeansException.class, () -> {
            var context = new AnnotationConfigApplicationContext(CircularDependenciesConfiguration.class);

        }, "Ini seharusnya error karna circular dependencies");
    }

}
