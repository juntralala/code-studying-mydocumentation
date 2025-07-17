package com.juntralala;

import com.juntralala.entity.Customer;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CRUDTest {

    @Test
    public void insert() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setId("Ozon");
        entityManager.persist(customer); // <- menyimpan data

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void find() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1"); // <- menyimpan data

        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Ozon", customer.getName());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void update() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1"); // <- menyimpan data
        customer.setName("Ujun");
        entityManager.merge(customer);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void delete() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1"); // <- menyimpan data
        entityManager.remove(customer);

        entityTransaction.commit();
        entityManager.close();
    }

}
