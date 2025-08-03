package com.juntralala;

import com.juntralala.lifecycle.lifecycleannotation.LifeCycleAnnotationCallbackConfiguration;
import com.juntralala.lifecycle.lifecycleannotation.Server;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleAnnotationCallbackTest {

    @Test
    public void test() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleAnnotationCallbackConfiguration.class);
        context.registerShutdownHook(); // <- Agar tidak perlu memanggil close() secara explisit

        Server server = new Server();
    }

}
