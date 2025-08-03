package com.juntralala.locking;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.CategoryRepository;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionOperations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LockingTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void locking1() {
        this.transactionOperations.executeWithoutResult(transactionStatus -> {
            try {
                Product product = this.productRepository.findFirstByIdIs(1L).orElse(null);
                assertNotNull(product);
                product.setPrice(10_999_888L);

                Thread.sleep(20_000);
                this.productRepository.save(product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void locking2() {
        this.transactionOperations.executeWithoutResult(transactionStatus -> {
            Product product = this.productRepository.findFirstByIdIs(1L).orElse(null);
            assertNotNull(product);
            product.setPrice(30_000_000L);

            this.productRepository.save(product);
        });
    }
}
