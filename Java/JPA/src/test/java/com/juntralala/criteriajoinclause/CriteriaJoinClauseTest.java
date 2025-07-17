package com.juntralala.criteriajoinclause;

import com.juntralala.entity.Member;
import com.juntralala.entity.SimpleMember;
import com.juntralala.entity.User;
import com.juntralala.entity.Wallet;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CriteriaJoinClauseTest {

    @Test
    public void testCriteriaJoin() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> u = criteria.from(User.class);
        Join<User, Wallet> w = u.join("wallet", JoinType.INNER);

        criteria.select(u);

        TypedQuery<User> query = entityManager.createQuery(criteria);
        List<User> users = query.getResultList();
        users.forEach(user -> {
            System.out.println(user.getId() + ": " + user.getName() + ", " + user.getWallet().getBalance());
        });

        entityTransaction.commit();
        entityManager.close();
    }
}
