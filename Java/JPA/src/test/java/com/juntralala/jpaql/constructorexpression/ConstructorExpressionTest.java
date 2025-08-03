package com.juntralala.jpaql.constructorexpression;

import com.juntralala.entity.SimpleMember;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConstructorExpressionTest {

    @Test
    public void testConstructorExpression() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<SimpleMember> query = entityManager.createQuery("SELECT new com.juntralala.entity.SimpleMember(m.id, m.name.middleName) FROM  Member m", SimpleMember.class);
        List<SimpleMember> simpleMembers = query.getResultList();

        for (SimpleMember simpleMember: simpleMembers) {
            System.out.println(simpleMember.getId() + ": " +  simpleMember.getName());
        }

        entityTransaction.commit();
        entityManager.close();
    }

}
