package com.juntralala.slice;

import com.juntralala.entity.Category;
import com.juntralala.entity.Product;
import com.juntralala.repositoy.CategoryRepository;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SliceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void slice() {
        Pageable firstPage = PageRequest.of(0, 1);
        Category category = categoryRepository.findByName("Gadget").orElse(null);
        assertNotNull(category);

        Slice<Product> slice = this.productRepository.findAllByCategory(category, firstPage);
        assertEquals("Laptop", slice.getContent().getFirst().getName());
        while (slice.hasNext()) {
            slice = this.productRepository.findAllByCategory(category, slice.nextPageable());
            System.out.println(slice.getContent().getFirst().getName());
        }
    }
}
