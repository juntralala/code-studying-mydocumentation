package com.juntralala.transcation.programmatic;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@SpringBootTest
public class PlatformTransactionManagerTest {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private CategoryRepository categoryRepository;

    private void error() {
        throw new RuntimeException("trigger rollback");
    }

    @Test
    public void manual() {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setTimeout(10);
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus transaction = transactionManager.getTransaction(definition); // begin transaction
        try {
           for (int i = 1; i<= 5; i++) {
               Category category = new Category();
               category.setName("Category-B" + i);
               categoryRepository.save(category);
           }
           this.error();
           transactionManager.commit(transaction);
        } catch (Throwable throwable) {
            transactionManager.rollback(transaction);
            Assertions.assertEquals("trigger rollback", throwable.getMessage());
        }
    }
}
