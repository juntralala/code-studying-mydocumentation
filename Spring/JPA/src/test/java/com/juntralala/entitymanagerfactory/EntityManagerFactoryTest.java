package com.juntralala.entitymanagerfactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityManagerFactoryTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void testEntityManagerFactory() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Assertions.assertNotNull(entityManagerFactory);
        Assertions.assertNotNull(entityManager);

        entityManager.close();
    }
}
