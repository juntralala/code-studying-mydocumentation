package com.juntralala.repositoy;

import com.juntralala.entity.Category;
import com.juntralala.entity.Product;
import com.juntralala.model.SimpleProduct;
import com.juntralala.model.SimpleProductRecord;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static jakarta.persistence.LockModeType.PESSIMISTIC_WRITE;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    <T> List<T> findAllByNameIs(String name, Class<T> model);

    List<SimpleProduct> findAllByNameLike(String name);

    @Lock(PESSIMISTIC_WRITE)
    Optional<Product> findFirstByIdIs(Long id);

    List<Product> findAllByCategory_Name(String name);

    List<Product> findAllByCategory_Name(String name, Sort sort);

    Page<Product> findAllByCategory_Name(String name, Pageable pageable);

    Long countByCategory_Name(String name);

    boolean existsByName(String name);

    @Transactional
    int deleteByName(String name);

    List<Product> searchProductUsingName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE :name OR p.category.name LIKE :name",
            countQuery = "SELECT count(p) FROM Product p WHERE p.name LIKE :name OR p.category.name LIKE :name")
    Page<Product> searchProduct(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Product p WHERE p.name = :name")
    int deleteProductUsingName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Product p SET p.price = 0 WHERE p.id=:id")
    int updatePriceToZero(@Param("id") Long id);

    Stream<Product> streamAllByCategory(Category category);

    Slice<Product> findAllByCategory(Category category, Pageable pageable);
}
