package com.juntralala.transcation.programmatic;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionOperations;

@SpringBootTest
public class TransactionOperationsTest {

    private TransactionOperations transactionOperations;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setTransactionOperations(TransactionOperations transactionOperations) {
        this.transactionOperations = transactionOperations;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void error() {
        throw new RuntimeException("Ups, go do transaction");
    }

    @Test
    public void programmatic() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            transactionOperations.executeWithoutResult(transactionStatus -> {
                for (int i = 1; i <= 5; i++) {
                    Category category = new Category();
                    category.setName("Category-A" + i);
                    categoryRepository.save(category);

                }
                this.error();
            });
        });
    }
}
