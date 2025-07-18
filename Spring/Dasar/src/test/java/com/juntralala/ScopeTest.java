package com.juntralala;

import com.juntralala.scope.Data;
import com.juntralala.scope.ScopeConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {

    @Test
    public void scope() {
        var context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);

        Data data1 = context.getBean(Data.class);
        Data data2 = context.getBean(Data.class);
        Data data3 = context.getBean(Data.class);

        Assertions.assertNotSame(data1, data2);
        Assertions.assertNotSame(data2, data3);
        Assertions.assertNotSame(data1, data3);
    }

}
