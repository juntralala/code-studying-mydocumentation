package com.juntralala;

import com.juntralala.entity.Category;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratedValueTest {

    @Test
    public void testGeneratedValue() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Category category = new Category();
        category.setName("Coding");
        category.setDescription("Hobby mengeksplorasi teknologi");
        entityManager.persist(category);

        Assertions.assertNotNull(category.getId());

        transaction.commit();
        entityManager.close();
    }

}
