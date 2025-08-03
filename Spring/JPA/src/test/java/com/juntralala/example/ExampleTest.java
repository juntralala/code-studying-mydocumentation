package com.juntralala.example;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@SpringBootTest
public class ExampleTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void example() {
        Category category = new Category();
        category.setName("Gadget");

        Example<Category> example = Example.of(category);
        List<Category> categories = this.categoryRepository.findAll(example);
        Assertions.assertEquals(1, categories.size());
    }

    @Test
    void exampleMatcher() {
        Category category = new Category();
        category.setName("Gadget");

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Category> example = Example.of(category, exampleMatcher);
        List<Category> categories = this.categoryRepository.findAll(example);
        Assertions.assertEquals(1, categories.size());
    }
}
