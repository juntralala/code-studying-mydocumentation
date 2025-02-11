package com.juntralala.factorybean;

import com.juntralala.factorybean.component.PaymentGatewayClientFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PaymentGatewayClientFactoryBean.class
})
public class FactoryBeanConfiguration {
}
