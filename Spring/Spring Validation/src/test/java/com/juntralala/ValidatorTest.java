package com.juntralala;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.juntralala.Main;
import org.juntralala.data.Person;
import org.juntralala.helper.SayHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest(classes = Main.class)
public class ValidatorTest {

    private Validator validator;
    private SayHello sayHello;

    @Autowired
    public void inject(Validator validator, SayHello sayHello) {
        this.validator = validator;
        this.sayHello = sayHello;
    }

    @Test
    void personNotValid() {
        Person person = new Person("", "");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(3, violations.size());
    }

    @Test
    void personValid() {
        Person person = new Person("1", "ozon");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        violations.forEach(System.out::println);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void validateMethodValid() {
        String message = sayHello.sayHello("ujun");

        Assertions.assertEquals("Hello ujun", message);
    }

    @Test
    void validateMethodInvalid() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            String message = sayHello.sayHello("");

            Assertions.assertEquals("Hello ujun", message);
        });
    }

}
