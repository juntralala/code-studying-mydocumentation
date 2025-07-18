package com.juntralala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.juntralala.Main;
import org.juntralala.data.Foo;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Validator;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Main.class)
public class PalindromeTest {

    private Validator validator;

    @Autowired
    public void inject(Validator validator) {
        this.validator = validator;
    }

    @Test
    void palindromeValid() {
        var violations = validator.validate(new Foo("kodok"));
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void palindromeInvalid() {
        var violations = validator.validate(new Foo("ujun"));
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void palindromeInvalidMessage() {
        var violations = validator.validate(new Foo("ujun"));
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals("the data is not palindrome", violations.stream().findFirst().get().getMessage());
    }

}
