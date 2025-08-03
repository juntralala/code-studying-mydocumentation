package com.juntralala.jpaql.orderby;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderByTest {

    @Test
    public void testOrderBy() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s ORDER BY s.name", Student.class);
        List<Student> students = query.getResultList();

        for (Student student: students) {
            System.out.println(student.getId() + ": " + student.getName());
        }

        entityTransaction.commit();
        entityManager.close();
    }

}
