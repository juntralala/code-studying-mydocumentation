package com.juntralala;

import com.juntralala.optionaldependencywithobjectprovider.ObjectProviderConfiguration;
import com.juntralala.optionaldependencywithobjectprovider.data.MultiFoo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ObjectProviderTest {

    @Test
    public void testObjectProvider() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ObjectProviderConfiguration.class);

        MultiFoo multiFoo = context.getBean(MultiFoo.class);

        Assertions.assertEquals(3, multiFoo.getFoos().size());
    }


}
