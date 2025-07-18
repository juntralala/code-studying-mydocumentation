package com.juntralala;

import com.juntralala.qualifierdicomponent.QualifierConfiguration;
import com.juntralala.qualifierdicomponent.components.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// ini contoh qualifier di @Component

public class QualifierTest {

    @Test
    public void testQualifer() {
        ApplicationContext context = new AnnotationConfigApplicationContext(QualifierConfiguration.class);

        CustomerService customerService = context.getBean(CustomerService.class);

        Assertions.assertNotNull(customerService.getNormalCustomerRepository());
        Assertions.assertNotNull(customerService.getPremiumCustomerRepository());

        Assertions.assertNotSame(
                customerService.getNormalCustomerRepository(),
                customerService.getPremiumCustomerRepository()
        );
    }

}
