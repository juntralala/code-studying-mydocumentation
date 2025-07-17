package com.juntralala.locking;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.Test;

public class PessimisticLockingTest {

    @Test
    public void testPessimisticLockingDemo1() throws InterruptedException {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "S001", LockModeType.PESSIMISTIC_WRITE);
        student.setName("John Doe");
        entityManager.merge(student);

        Thread.sleep(10_000L);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void testPessimisticLockingDemo2()  {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "S001", LockModeType.PESSIMISTIC_WRITE);
        student.setName("John Sena");
        entityManager.merge(student);

        entityTransaction.commit();
        entityManager.close();
    }

}
