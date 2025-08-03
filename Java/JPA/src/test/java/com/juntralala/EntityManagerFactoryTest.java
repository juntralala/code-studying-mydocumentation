package com.juntralala;

import com.juntralala.util.JpaUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntityManagerFactoryTest {

    @Test
    public void createEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("belajar-jpa");

        assertNotNull(entityManagerFactory);

        entityManagerFactory.close();
    }

    @Test
    public void createEntityManagerFactoryWithUtil() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

        assertNotNull(entityManagerFactory);

        entityManagerFactory.close();
    }
}
