package com.juntralala.dependency_injection.problem_circular_dependency;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class CyclicB {

    private CyclicC cyclicC;

}
