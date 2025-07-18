package com.juntralala.countquerymethod;

import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountQueryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void count() {
        Long count  = this.productRepository.count(); // <- bawaan repository, tapi menghitung semua data
        Assertions.assertEquals(2L, count);

        count = this.productRepository.countByCategory_Name("Gadget");
        Assertions.assertEquals(2L, count);

        count = this.productRepository.countByCategory_Name("tidak ada");
        Assertions.assertEquals(0L, count);
    }
}
