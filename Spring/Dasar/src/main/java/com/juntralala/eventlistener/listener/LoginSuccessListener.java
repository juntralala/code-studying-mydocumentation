package com.juntralala.eventlistener.listener;

import com.juntralala.eventlistener.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// <===========> cara kedua (membuat event listener), dengan annotasi  <===========>
@Slf4j
@Component
public class LoginSuccessListener{

    @EventListener({LoginSuccessEvent.class})
    public void onApplicationEvent(LoginSuccessEvent event) {
        log.info("Success login for user {}", event.getUser());
    }
}

// <==============> cara pertama, dengan membuat turuanan interface Application Listener <==============>
//@Slf4j
//@Component
//public class LoginSuccessListener implements ApplicationListener<LoginSuccessEvent> {
//
//    @Override
//    public void onApplicationEvent(LoginSuccessEvent event) {
//        log.info("Success login for user {}", event.getUser());
//    }
//}
