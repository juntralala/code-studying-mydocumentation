package com.juntralala.existquerymethod;

import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ExistsQueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void existsQuery() {
        boolean isExists = this.productRepository.existsByName("Laptop");
        assertTrue(isExists);

        isExists = this.productRepository.existsByName("Tidak Ada");
        assertFalse(isExists);
    }
}
