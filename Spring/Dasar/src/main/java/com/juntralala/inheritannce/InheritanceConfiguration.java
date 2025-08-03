package com.juntralala.inheritannce;

import com.juntralala.inheritannce.service.MerchantService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        MerchantService.class
})
public class InheritanceConfiguration {

}
