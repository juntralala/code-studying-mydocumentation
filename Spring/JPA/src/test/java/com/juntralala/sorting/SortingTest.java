package com.juntralala.sorting;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.CategoryRepository;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class SortingTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSorting() {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<Product> products = productRepository.findAllByCategory_Name("Gadget", sort);

        assertFalse(products.isEmpty());
        assertEquals("Mother Board", products.get(0).getName());
        assertEquals("Laptop", products.get(1).getName());
    }
}