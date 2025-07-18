package com.juntralala.spesification;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SpringBootTest
public class SpecificationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSpecification() {
        Specification<Product> specification = (root, criteria, builder) -> {
            return criteria.where(
                    builder.or(
                            builder.equal(root.get("name"), "Laptop"),
                            builder.equal(root.get("name"), "Mother Board")
                    )
            ).getRestriction();
        };

        List<Product> products = this.productRepository.findAll(specification);
        Assertions.assertEquals(2, products.size());
    }
}
