package com.juntralala.jpaql.namedquery;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NamedQueryTest {

    @Test
    public void testNamedQuery() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findAllByName", Student.class);
        query.setParameter("name", "Hanako-Kun");
        List<Student> students = query.getResultList();

        for (Student student: students) {
            System.out.println(student.getId() + ": " + student.getName());
        }

        entityTransaction.commit();
        entityManager.close();
    }

}
