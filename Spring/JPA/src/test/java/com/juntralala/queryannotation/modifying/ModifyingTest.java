package com.juntralala.queryannotation.modifying;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ModifyingTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void modifyingInQueryAnnotation() {
        this.transactionOperations.executeWithoutResult(transactionStatus -> {
            int total = this.productRepository.deleteProductUsingName("Wrong");
            assertEquals(0, total);

            total = this.productRepository.updatePriceToZero(1L);
            assertEquals(1, total);

            Product product = this.productRepository.findById(1L).orElse(null);
            assertNotNull(product);
            assertEquals(0, product.getPrice());
        });
    }
}
