package com.juntralala.declarativetransaction;

import com.juntralala.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeclarativeTransactionTest {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Test
    public void rollbackTransactionSuccess() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            this.categoryService.create();
        });
    }

    @Test
    public void rollbackTransactionFailed() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            this.categoryService.test();
        });
    }
}
