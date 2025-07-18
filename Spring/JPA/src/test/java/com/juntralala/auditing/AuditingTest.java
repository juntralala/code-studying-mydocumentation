package com.juntralala.auditing;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditingTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void auditing() {
        Category category = new Category();
        category.setName("Sample Audit");
        this.categoryRepository.save(category);

        Assertions.assertNotNull(category.getId());
        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getUpdatedAt());
    }
}
