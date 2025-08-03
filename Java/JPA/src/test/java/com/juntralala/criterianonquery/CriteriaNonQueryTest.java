package com.juntralala.criterianonquery;

import com.juntralala.entity.Student;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;

public class CriteriaNonQueryTest {

    @Test
    void nonQuery() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Student> criteria = builder.createCriteriaUpdate(Student.class);
        Root<Student> b = criteria.from(Student.class);

        criteria.set(b.get("name"), "Apple Updated");
        criteria.where(builder.equal(b.get("id"), "apple"));

        Query query = entityManager.createQuery(criteria);
        int impactedRecords = query.executeUpdate();
        System.out.println("Success update " + impactedRecords + " records");

        transaction.commit();
        entityManager.close();
    }
}
