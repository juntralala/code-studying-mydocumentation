package com.juntralala.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

    @Test
    public void messageSourceDefaultLocale() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageSourceApp.class);
        MessageSource messageSource = context.getBean(MessageSource.class);

        String hello = messageSource.getMessage("hello", new Object[]{"ujun"}, Locale.getDefault());
        Assertions.assertEquals("Hello ujun", hello);
    }

    @Test
    public void messageSourceLocaleIndonesia() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageSourceApp.class);

        // langsung menggunakan ApplicationContext nya juga bisa
        String hello = context.getMessage("hello", new Object[]{"ujun"}, new Locale("id", "ID"));
        Assertions.assertEquals("Halo ujun", hello);
    }

}

@Configuration
class MessageSourceApp {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("my");
        return messageSource;
    }

}
