package com.juntralala.criteria;

import com.juntralala.entity.Member;
import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CriteriaTest {

    @Test
    public void criteria() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);

        TypedQuery<Student> query = entityManager.createQuery(criteria);
        List<Student> students = query.getResultList();
        students.forEach(student -> {
            System.out.println(student.getId() + ": " + student.getName());
        });

        entityTransaction.commit();
        entityManager.close();
    }

}
