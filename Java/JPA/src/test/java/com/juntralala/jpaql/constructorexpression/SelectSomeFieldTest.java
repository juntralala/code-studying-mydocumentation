package com.juntralala.jpaql.constructorexpression;

import com.juntralala.entity.Member;
import com.juntralala.entity.User;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SelectSomeFieldTest {

    @Test
    public void testSomeFields() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("SELECT m.id, m.name.middleName FROM  Member m", Object[].class);
        List<Object[]> objects = query.getResultList();

        for (Object[] object: objects) {
            System.out.println(object[0] + ": " +  object[1]);
        }

        entityTransaction.commit();
        entityManager.close();
    }

}
