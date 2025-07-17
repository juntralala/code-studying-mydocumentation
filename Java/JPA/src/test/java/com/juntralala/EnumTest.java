package com.juntralala;

import com.juntralala.entity.Customer;
import com.juntralala.entity.CustomerType;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    public void testEnum() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("3");
        customer.setName("Urik");
        customer.setType(CustomerType.PREMIUM);
        entityManager.persist(customer); // <- menyimpan data

        entityTransaction.commit();
        entityManager.close();
    }

}
