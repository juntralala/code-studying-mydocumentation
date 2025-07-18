package com.juntralala.eventlistener;

import com.juntralala.eventlistener.event.LoginSuccessEvent;
import com.juntralala.eventlistener.listener.LoginSuccessListener;
import com.juntralala.eventlistener.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        LoginSuccessListener.class,
        UserService.class
})
public class EventListenerConfiguration {
}
