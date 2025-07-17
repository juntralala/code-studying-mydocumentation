package com.juntralala.criteriawhere;

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

public class CriteriaWhereClauseTest {

    @Test
    public void testCriteriaWhere() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> s = criteria.from(Student.class);
        criteria.where(
                builder.or(
                        builder.equal(s.get("name"), "Hanako-Kun"),
                        builder.equal(s.get("name"), "Murid NPC-0")
                )
        );

        TypedQuery<Student> query = entityManager.createQuery(criteria);
        List<Student> students = query.getResultList();

        students.forEach(student -> System.out.println(student.getId() + ": " + student.getName()));

        entityTransaction.commit();
        entityManager.close();
    }
}
