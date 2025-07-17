package com.juntralala;

import com.juntralala.entity.Member;
import com.juntralala.entity.Name;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionPropertyTest {

    @Test
    public void testCollection() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Coding");
        hobbies.add("Gaming");
        hobbies.add("War");

        Name name = new Name();
        name.setTitle("Bro");
        name.setFirstName("M");
        name.setMiddleName("Luthfi");
        name.setLastName("Thoyyib");

        Member member = new Member();
        member.setEmail("zon@email.com");
        member.setName(name);
        member.setHobbies(hobbies);

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void update() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = entityManager.find(Member.class, 4);
        member.getHobbies().add("Reading");

        entityManager.merge(member);

        entityTransaction.commit();
        entityManager.close();
    }

}
