package com.juntralala.paging;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PagingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void paging() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "id"));
        Page<Product> products = this.productRepository.findAllByCategory_Name("Gadget", pageable);

        assertEquals(1, products.getContent().size());
        assertEquals("Mother Board", products.getContent().getFirst().getName());
        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());

        pageable = PageRequest.of(1, 1, Sort.Direction.DESC, "id");
        products = this.productRepository.findAllByCategory_Name("Gadget", pageable);

        assertEquals(1, products.getContent().size());
        assertEquals("Laptop", products.getContent().getFirst().getName());
        assertEquals(1, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
    }
}
