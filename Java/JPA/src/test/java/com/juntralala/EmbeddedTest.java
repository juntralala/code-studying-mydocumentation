package com.juntralala;

import com.juntralala.entity.Category;
import com.juntralala.entity.Member;
import com.juntralala.entity.Name;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmbeddedTest {

    @Test
    public void testEmbedded() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = new Member();
        Name name = new Name();
        member.setEmail("zon@gmail.com");
        name.setTitle("Bro");
        name.setFirstName("M");
        name.setMiddleName("Luthfi");
        name.setLastName("Thoyyib");
        member.setName(name);
        entityManager.persist(member);

        Assertions.assertNotNull(member.getId());

        transaction.commit();
        entityManager.close();
    }

}
