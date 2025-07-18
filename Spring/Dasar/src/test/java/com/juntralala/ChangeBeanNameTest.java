package com.juntralala;

import com.juntralala.bean.Foo;
import com.juntralala.bean.change_bean_name.ChangeBeanNameConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ChangeBeanNameTest {

    @Test
    void changeBeanName() {
        var context = new AnnotationConfigApplicationContext(ChangeBeanNameConfiguration.class);

        Foo fooFirst = context.getBean("fooFirst", Foo.class);
        Foo fooSecond = context.getBean("fooSecond", Foo.class);

        Assertions.assertNotSame(fooFirst, fooSecond);
    }

}
