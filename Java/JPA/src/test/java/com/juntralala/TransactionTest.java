package com.juntralala;

import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void transaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

            Assertions.assertNotNull(entityTransaction);

        try {
            entityTransaction.begin();
            // doing crud
            entityTransaction.commit();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        entityManager.close();
    }

}
