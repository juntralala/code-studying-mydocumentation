package com.juntralala;

import com.juntralala.bean.Foo;
import com.juntralala.springbootapplication.FooApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {FooApplication.class})
public class FooApplicationTest {

    @Autowired
    Foo foo;

    @Test
    public void testFoo() {
        Assertions.assertNotNull(foo);
    }

}
