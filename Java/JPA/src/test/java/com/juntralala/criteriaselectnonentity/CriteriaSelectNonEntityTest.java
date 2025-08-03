package com.juntralala.criteriaselectnonentity;

import com.juntralala.entity.Member;
import com.juntralala.entity.SimpleMember;
import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CriteriaSelectNonEntityTest {

    @Test
    public void testSelectNonEntity() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(criteriaBuilder.array(root.get("id"), root.get("name")));

        TypedQuery<Object[]> query = entityManager.createQuery(criteria);
        List<Object[]> objects = query.getResultList();
        objects.forEach(o -> {
            System.out.println(o[0] + ": " + o[1]);
        });

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void testSelectConstructorExpression() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<SimpleMember> criteria = builder.createQuery(SimpleMember.class);
        Root<Member> member = criteria.from(Member.class);
        criteria.select(builder.construct(SimpleMember.class, member.get("id"), member.get("name").get("middleName")));

        TypedQuery<SimpleMember> query = entityManager.createQuery(criteria);
        List<SimpleMember> simpleMembers = query.getResultList();
        simpleMembers.forEach(simpleMember -> {
            System.out.println(simpleMember.getId() + ": " + simpleMember.getName());
        });

        entityTransaction.commit();
        entityManager.close();
    }

}
