package com.juntralala;

import com.juntralala.inheritannce.InheritanceConfiguration;
import com.juntralala.inheritannce.service.MerchantService;
import com.juntralala.inheritannce.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTest {

    @Test
    @DisplayName("Test inheritance dalam pengaksesan Bean")
    public void testInheritance() {
        ApplicationContext context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);

        MerchantService merchantService = context.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = context.getBean(MerchantServiceImpl.class);

        Assertions.assertEquals(merchantService, merchantServiceImpl);
    }

}
