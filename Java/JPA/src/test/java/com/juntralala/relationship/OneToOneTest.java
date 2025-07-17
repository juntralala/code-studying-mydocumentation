package com.juntralala.relationship;

import com.juntralala.entity.Credential;
import com.juntralala.entity.User;
import com.juntralala.entity.Wallet;
import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneToOneTest {

    @Test
    public void oneToOnePersist() { // contoh one to one yg primary key ke primary key
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = new User();
        user.setId("U001");
        user.setName("Ujun");
        entityManager.persist(user);

        Credential credential = new Credential();
        credential.setId("U001");
        credential.setEmail("ujun@email.com");
        credential.setPassword("rahasia");
        entityManager.persist(credential);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    public void oneToOneFind() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "U001");
        Credential credential = user.getCredential();
        Wallet wallet = user.getWallet();

        Assertions.assertNotNull(credential);
        Assertions.assertEquals("ujun@email.com", credential.getEmail());
        Assertions.assertEquals("rahasia", credential.getPassword());
        Assertions.assertNotNull(wallet);
        Assertions.assertEquals(20_000L, wallet.getBalance());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void oneToOneInsert() { // join primary key ke yg bukan primary key
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "U001");
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(20_000L);
        entityManager.persist(wallet);

        entityTransaction.commit();
        entityManager.close();
    }
}
