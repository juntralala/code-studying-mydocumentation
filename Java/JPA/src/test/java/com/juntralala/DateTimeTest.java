package com.juntralala;

import com.juntralala.entity.Category;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTimeTest {


    @Test
    public void testDate() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Category category = new Category();
        category.setName("Gaming");
        category.setDescription("Bermain Game");
        category.setCreatedAt(Calendar.getInstance());
        category.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(category);

        Assertions.assertNotNull(category.getId());

        transaction.commit();
        entityManager.close();
    }

}
