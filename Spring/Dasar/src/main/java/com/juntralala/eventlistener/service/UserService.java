package com.juntralala.eventlistener.service;

import com.juntralala.eventlistener.data.User;
import com.juntralala.eventlistener.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public boolean login(String username, String password) {
        if(isLoginSuccess(username, password)) {
            eventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
            return true;
        }

        return false;
    }

    public static boolean isLoginSuccess(String username, String password) {
        return (username.equals("ujun") && password.equals("rahasia"));
    }

}
