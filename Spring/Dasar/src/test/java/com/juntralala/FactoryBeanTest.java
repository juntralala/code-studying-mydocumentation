package com.juntralala;

import com.juntralala.factorybean.FactoryBeanConfiguration;
import com.juntralala.factorybean.data.PaymentGatewayClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);

        PaymentGatewayClient client = context.getBean(PaymentGatewayClient.class);

        Assertions.assertEquals("https://payment.com/", client.getEndpoint());
        Assertions.assertEquals("PUBLIC", client.getPublicKey());
        Assertions.assertEquals("PRIVATE", client.getPrivateKey());
    }

}
