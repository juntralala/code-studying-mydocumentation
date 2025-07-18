package com.juntralala.querymethod;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void queryMethod() {
        Category category1 = categoryRepository.findByName("Gawai").orElse(null);
        assertNotNull(category1);
        assertEquals("Gawai", category1.getName());

        List<Category> categories = categoryRepository.findAllByNameContains("Category");
        assertFalse(categories.isEmpty());
    }
}
