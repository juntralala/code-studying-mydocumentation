package com.juntralala;

import com.juntralala.entity.Category;
import com.juntralala.entity.Customer;
import com.juntralala.entity.CustomerType;
import com.juntralala.entity.Member;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventListenerTest {

    @Test
    public void listen() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Category category = new Category();
        category.setName("Gadget");
        entityManager.persist(category);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void listenEntity() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = entityManager.find(Member.class, 1);
        Assertions.assertNotNull(member.getFullName());

        entityTransaction.commit();
        entityManager.close();
    }

}
