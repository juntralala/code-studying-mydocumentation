package com.juntralala.jpaql.joinclause;

import com.juntralala.entity.Student;
import com.juntralala.entity.User;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JoinClauseTest {

    @Test
    public void testJoin() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM  User u JOIN u.wallet", User.class);
        List<User> users = query.getResultList();

        for (User user: users) {
            System.out.println(user.getId() + ": " + user.getName() + ", Balance: " + user.getWallet().getBalance());
        }

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void testJoinFetch() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM  User u JOIN FETCH u.wallet", User.class);
        List<User> users = query.getResultList();

        for (User user: users) {
            System.out.println(user.getId() + ": " + user.getName() + ", Balance: " + user.getWallet().getBalance());
        }

        entityTransaction.commit();
        entityManager.close();
    }

}
