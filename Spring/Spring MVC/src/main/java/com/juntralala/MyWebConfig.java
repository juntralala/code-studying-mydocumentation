package com.juntralala;

import com.juntralala.interceptor.SessionInterceptor;
import com.juntralala.resolver.PartnerArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    private SessionInterceptor sessionInterceptor;

    private PartnerArgumentResolver partnerArgumentResolver;

    @Autowired
    public void setSessionInterceptor(SessionInterceptor sessionInterceptor) {
        this.sessionInterceptor = sessionInterceptor;
    }

    @Autowired
    public void setPartnerArgumentResolver(PartnerArgumentResolver partnerArgumentResolver) {
        this.partnerArgumentResolver = partnerArgumentResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/user/*"); // <- kalau path tidak ditambahkan maka akan beraku kesemua path
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(partnerArgumentResolver);
    }
}
