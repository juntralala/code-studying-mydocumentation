package com.juntralala.messagesourceinspringboot;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceApp.class)
public class SpringBootMessageSourceTest {

    @Autowired
    private SampleSource sampleSource;

    @Test
    public void testSpringBootMessageSource() {
        String hello = sampleSource.helloUjun(Locale.getDefault());
        Assertions.assertEquals("Hello ujun", hello);
    }

    @Test
    public void testSpringBootMessageSourceIndonesia() {
        String hello = sampleSource.helloUjun(new Locale("id", "ID"));
        Assertions.assertEquals("Halo ujun", hello);
    }

}

@SpringBootApplication
class SpringBootMessageSourceApp {
}

@Component
class SampleSource implements MessageSourceAware {

    private MessageSource messageSource;

    public String helloUjun(Locale locale) {
        return this.messageSource.getMessage("hello", new Object[]{"ujun"}, locale);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
