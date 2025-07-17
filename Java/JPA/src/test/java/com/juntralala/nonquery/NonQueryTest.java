package com.juntralala.nonquery;

import com.juntralala.entity.User;
import com.juntralala.entity.Wallet;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;

public class NonQueryTest {

    @Test
    public void testNonQuery() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("UPDATE Student s SET s.name=:name WHERE s.id=:id");
        query.setParameter("name", "OZON");
        query.setParameter("id", "S001");
        int effectedRows = query.executeUpdate();

        System.out.println("Effected Rows: " + effectedRows);

        entityTransaction.commit();
        entityManager.close();
    }

}
