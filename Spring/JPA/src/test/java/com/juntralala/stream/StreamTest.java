package com.juntralala.stream;

import com.juntralala.entity.Category;
import com.juntralala.entity.Product;
import com.juntralala.repositoy.CategoryRepository;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionOperations;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StreamTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionOperations transactionOperations;


    @Test
    void testStream() {
        this.transactionOperations.executeWithoutResult(transactionStatus -> {
            Category category = this.categoryRepository.findByName("Gadget").orElse(null);
            assertNotNull(category);

            Stream<Product> stream = productRepository.streamAllByCategory(category);
            stream.forEach(product -> System.out.println(product.getId() + ": " + product.getName()));
        });
    }
}
