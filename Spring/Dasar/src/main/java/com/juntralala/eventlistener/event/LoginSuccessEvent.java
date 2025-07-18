package com.juntralala.eventlistener.event;

import lombok.Getter;
import com.juntralala.eventlistener.data.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class LoginSuccessEvent extends ApplicationEvent {

    @Getter
    private final User user;

    public LoginSuccessEvent(User user) {
        super(user);
        this.user = user;
    }
}
