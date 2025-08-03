package com.juntralala;

import com.juntralala.entity.Customer;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class CloumnTest {

    @Test
    public void column() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer("2", "john", "jhon@email.com");
        entityManager.persist(customer);

        transaction.commit();
        entityManager.close();
    }

}
