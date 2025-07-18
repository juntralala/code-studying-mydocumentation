package com.juntralala.aware;

import com.juntralala.aware.service.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        AuthenticationService.class
})
public class AwareConfiguration {
}
