package com.juntralala.nativequery;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NamedNativeQueryTest {
    @Test
    public void testNamedNative() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Student> query = entityManager.createNamedQuery("Student.native.findAll", Student.class);
        List<Student> students = query.getResultList();

        students.forEach(student -> {
            System.out.println(student.getId() + ": " + student.getName());
        });

        transaction.commit();
        entityManager.close();
    }
}
