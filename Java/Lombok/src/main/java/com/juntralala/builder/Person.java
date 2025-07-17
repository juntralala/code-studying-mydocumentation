package com.juntralala.builder;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Person {

    private String id;
    private String name;
    private String age;
    @Singular
    private List<String> hobbies;

}
