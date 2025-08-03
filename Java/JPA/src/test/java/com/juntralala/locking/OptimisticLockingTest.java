package com.juntralala.locking;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class OptimisticLockingTest {

    @Test
    public void testOptimisticLockingInsert() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = new Student();
        student.setId("S001");
        student.setName("Zunaidi");
        entityManager.persist(student); // kolom version otomatis terisi

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void testOptimisticLockingDemo1() throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "S001");
        student.setName("OZON");
        entityManager.merge(student);

        Thread.sleep(10_000L);

        entityTransaction.commit(); // disini error, karna duluan demo2 yang sukses
        entityManager.close();
    }

    @Test
    public void testOptimisticLockingDemo2() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "S001");
        student.setName("Juned");
        entityManager.merge(student);

        entityTransaction.commit();
        entityManager.close();
    }

}
