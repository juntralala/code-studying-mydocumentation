package com.juntralala.dependency_injection.problem_circular_dependency;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CyclicA {

    private CyclicB cyclicB;

}
