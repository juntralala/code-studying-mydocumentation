package com.juntralala.projection;

import com.juntralala.model.ProductPrice;
import com.juntralala.model.SimpleProduct;
import com.juntralala.model.SimpleProductRecord;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjectionTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void projection() {
        List<SimpleProduct> products = this.productRepository.findAllByNameLike("Laptop");
        assertEquals(1, products.size());
        assertEquals("Laptop", products.getFirst().getName());
        assertEquals("Gadget", products.getFirst().getCategory_Name());
    }

    @Test
    void projectionRecord() {
        List<SimpleProductRecord> products = this.productRepository.findAllByNameIs("Laptop", SimpleProductRecord.class);
        assertEquals(1, products.size());
        assertEquals("Laptop", products.getFirst().name());
        assertEquals("Gadget", products.getFirst().category_Name());
    }

    @Test
    void projectionPrice() {
        List<ProductPrice> products = this.productRepository.findAllByNameIs("Laptop", ProductPrice.class); // use dynamic projection
        assertEquals(1, products.size());
        assertEquals(30_000_000L, products.getFirst().price());
    }
}
