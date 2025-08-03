package com.juntralala.criteriaparameter;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CriteriaParameterTest {

    @Test
    public void testCriteriaParameter() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> s = criteria.from(Student.class);
        ParameterExpression<String> nameParam = builder.parameter(String.class);
        criteria.where(
                builder.like(s.get("name"), nameParam)
        );

        TypedQuery<Student> query = entityManager.createQuery(criteria);
        query.setParameter(nameParam, "%Hanako%");
        List<Student> students = query.getResultList();
        students.forEach(student -> System.out.println(student.getId() + ": " + student.getName()));

        entityTransaction.commit();
        entityManager.close();
    }
}
