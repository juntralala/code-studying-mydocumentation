package com.juntralala.namedquery;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NamedQueryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testNamedQuery() {
        Pageable pageable = PageRequest.of(0, 1); // <- jika kita tambahkan Sort pada Paging, tidak akan dihiraukan. Jadi kita cuman bisa menambahkan sorting pada JP QL pada named query nya saja
        List<Product> products = this.productRepository.searchProductUsingName("Laptop", pageable);
        assertEquals(1, products.size());
        assertEquals("Laptop", products.getFirst().getName());
    }
}
