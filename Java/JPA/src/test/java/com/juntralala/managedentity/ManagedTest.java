package com.juntralala.managedentity;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class ManagedTest {

    @Test
    public void testManagedEntity() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = new Student();
        student.setId("S7");
        student.setName("Amane");
        entityManager.persist(student);

        student.setName("Hanako"); // <- melakukan query update saat commit (lihat log)

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testManagedEntityFind() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = entityManager.find(Student.class, "S7");
        student.setName("Hanako-Kun"); // <- melakukan query update saat commit (lihat log)

        // tidak ada pemanggilan merge

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testDetach() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = entityManager.find(Student.class, "S7");
        entityManager.detach(student);             // melakukan unmanage terhadap entity agar tidak menyimpan perubahan pada saat commit transaction
        student.setName("Legenda sekolah ke-7");

        // tidak ada pemanggilan merge

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testUnmanagedAfterTransaction() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = entityManager.find(Student.class, "S7");

        transaction.commit();
        entityManager.close();

        student.setName("Legenda sekolah ke-7"); // tidak akan disimpan ke database karna lifecycle managedentity hanya di dalam transaction saja, setelah transaction maka entitynya akan menjadi unmanaged
    }
}
