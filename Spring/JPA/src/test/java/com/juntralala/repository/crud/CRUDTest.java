package com.juntralala.repository.crud;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CRUDTest {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Test
    void create() {
        Category category = new Category();
        category.setName("Gadget");

        categoryRepository.save(category);

        Assertions.assertNotNull(category.getId());
    }

    @Test
    void update() {
        Category category = categoryRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(category);

        category.setName("Gawai");
        categoryRepository.save(category);

        category = categoryRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(category);
        Assertions.assertEquals("Gawai", category.getName());
    }
}
