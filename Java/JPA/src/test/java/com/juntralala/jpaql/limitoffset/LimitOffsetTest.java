package com.juntralala.jpaql.limitoffset;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LimitOffsetTest {
    @Test
    public void testLimitOffset() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        query.setFirstResult(5); // <- offset
        query.setMaxResults(5); // <- limit
        List<Student> students = query.getResultList();

        for (Student student: students) {
            System.out.println(student.getId() + ": " + student.getName());
        }

        entityTransaction.commit();
        entityManager.close();
    }
}
