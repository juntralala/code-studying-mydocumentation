package com.juntralala.nativequery;

import com.juntralala.entity.Category;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NativeQueryTest {

    @Test
    public void testNativeQuery() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM categories WHERE created_at IS NOT NULL", Category.class);
        List<Category> categories = (List<Category>) query.getResultList(); // method query.getResultList() sebenarnya mengembalikan List<Object>

        categories.forEach(category -> {
            System.out.println(category.getId() + ": " + category.getName() + ": " + category.getDescription());
        });

        transaction.commit();
        entityManager.close();
    }

}
