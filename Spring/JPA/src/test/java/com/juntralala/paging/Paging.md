# Paging
* Selain Sort, Spring Data Repository juga mendukung paging seperti di EntityManager
* Caranya kita bisa tambahkan parameter Pageable di posisi terakhir parameter
* Pageable adalah sebuah interface, biasanya kita akan menggunakan PageRequest sebagai class implementasinya
* Dan jika sudah menggunakan Pageable, kita tidak perlu lagi menggunakan Sort, karena sudah bisa dihandle oleh Pageable
* https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/PageRequest.html 

```java
/*
Kode sebelum, return method  this.productRepository.findAllByCategory_Name("Gadget", pageable) menjadi Page<Product>
 */

package com.juntralala.paging;

import com.juntralala.entity.Product;
import com.juntralala.repositoy.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        List<Product> products = this.productRepository.findAllByCategory_Name("Gadget", pageable);

        assertEquals(1, products.size());
        assertEquals("Mother Board", products.getFirst().getName());

        pageable = PageRequest.of(1, 1, Sort.Direction.DESC, "id");
        products = this.productRepository.findAllByCategory_Name("Gadget", pageable);

        assertEquals(1, products.size());
        assertEquals("Laptop", products.getFirst().getName());
    }
}
```
