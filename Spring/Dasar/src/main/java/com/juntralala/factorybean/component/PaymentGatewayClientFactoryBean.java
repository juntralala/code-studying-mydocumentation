package com.juntralala.factorybean.component;

import com.juntralala.factorybean.data.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("paymentGatewayClient")
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {

    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndpoint("https://payment.com/");
        client.setPublicKey("PUBLIC");
        client.setPrivateKey("PRIVATE");
        return client;
    }

    @Override
    public Class<PaymentGatewayClient> getObjectType() {
        return PaymentGatewayClient.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

}
