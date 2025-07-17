package com.juntralala.jpaql.aggregatequery;

import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AggregateQueryTest {

    @Test
    public void testAggregate() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("SELECT min(w.balance), max(w.balance), avg(w.balance) FROM Wallet w", Object[].class);
        List<Object[]> objects = query.getResultList();

        objects.forEach((object) -> {
            System.out.println("Min: " + object[0]);
            System.out.println("Max: " + object[1]);
            System.out.println("Avg: " + object[2]);
        });

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void testGroupBy() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("SELECT min(w.balance), max(w.balance), avg(w.balance) FROM Wallet w GROUP BY w.user.id", Object[].class);
        List<Object[]> objects = query.getResultList();

        objects.forEach((object) -> {
            System.out.println("Min: " + object[0]);
            System.out.println("Max: " + object[1]);
            System.out.println("Avg: " + object[2]);
        });

        entityTransaction.commit();
        entityManager.close();
    }
}
