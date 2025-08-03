package com.juntralala;

import com.juntralala.lifecycle.Connection;
import com.juntralala.lifecycle.LifeCycleConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleCallbackTest {

    /**
     * class ApplicationContext tidak memiliki close method, sehingga event destroy bean tidak bisa terpanggil.
     * Agar bisa menggunakan fitur close kita harus menggunakan class turunannya ConfigurableApplicationContext
     */
    @Test
    public void lifeCycleCallback() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);

        Connection connection = context.getBean(Connection.class);

        Assertions.assertNotNull(connection);

        context.close();
    }

}
