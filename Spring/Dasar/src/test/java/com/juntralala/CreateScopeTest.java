package com.juntralala;

import com.juntralala.createscope.CreateScopeConfiguration;
import com.juntralala.createscope.Information;
import org.apache.logging.log4j.util.Chars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CreateScopeTest {

    @Test
    public void testCreateCustomScope() {
        var context = new AnnotationConfigApplicationContext(CreateScopeConfiguration.class);

        Information information1 = context.getBean(Information.class); // object information hanya dibuat 2 kali
        Information information2 = context.getBean(Information.class);
        Information information3 = context.getBean(Information.class);
        Information information4 = context.getBean(Information.class);

        Assertions.assertNotSame(information1, information2);
        Assertions.assertSame(information1, information3);
        Assertions.assertSame(information2, information4);
    }

}
