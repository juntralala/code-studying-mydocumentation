package com.juntralala.queryrelation;

import com.juntralala.entity.Category;
import com.juntralala.entity.Product;
import com.juntralala.repositoy.CategoryRepository;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class QueryRelationTest {

    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void createProducts() {
        Category category = this.categoryRepository.findByName("Gadget").orElse(null);
        Assertions.assertNotNull(category);

        {
            Product product = new Product();
            product.setName("Laptop");
            product.setPrice(20_000_000L);
            product.setCategory(category);
            this.productRepository.save(product);
        }

        {
            Product product = new Product();
            product.setName("Mother Board");
            product.setPrice(12_000_000L);
            product.setCategory(category);
            this.productRepository.save(product);
        }
    }

    @Test
    void findByCategoryName() {
        List<Product> products = this.productRepository.findAllByCategory_Name("Gadget");
        assertEquals(2, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals("Mother Board", products.get(1).getName());
    }
}
