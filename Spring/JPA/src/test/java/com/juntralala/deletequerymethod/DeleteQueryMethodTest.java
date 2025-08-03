package com.juntralala.deletequerymethod;

import com.juntralala.entity.Category;
import com.juntralala.entity.Product;
import com.juntralala.repositoy.CategoryRepository;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionOperations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DeleteQueryMethodTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void deleteSingleTransactionOperations() {
        this.transactionOperations.executeWithoutResult(transactionStatus -> {
            Category category = this.categoryRepository.findByName("Gadget").orElse(null);
            assertNotNull(category);

            Product product = new Product();
            product.setName("Smartphone");
            product.setPrice(6_000_000L);
            product.setCategory(category);
            this.productRepository.save(product);

            int deleted = productRepository.deleteByName("Smartphone"); // delete tidak bisa dijalankan jika tidak menggunakan Transaction, penjelasan alasannya ada di Repository Transaction
            assertEquals(1, deleted);

            deleted = productRepository.deleteByName("tidak ada");
            assertEquals(0, deleted);
        });
    }

    @Test
    void separatedTransactions() {
        Category category = this.categoryRepository.findByName("Gadget").orElse(null);
        assertNotNull(category);

        Product product = new Product();
        product.setName("Smartphone");
        product.setPrice(6_000_000L);
        product.setCategory(category);
        this.productRepository.save(product); // transaksi 1

        int deleted = productRepository.deleteByName("Smartphone"); // transaksi 2 <- misal jika delete ini gagal, maka transaksi 2 saja yang di rollback, karna tiap transaksi di test ini terpisah
        assertEquals(1, deleted);

        deleted = productRepository.deleteByName("tidak ada"); // transaksi 3
        assertEquals(0, deleted);
    }
}
