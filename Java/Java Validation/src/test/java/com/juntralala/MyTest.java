package com.juntralala;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public class MyTest {

    protected static ValidatorFactory validatorFactory;
    protected Validator validator;

    @BeforeAll
    static void beforeAll() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
    }

    @BeforeEach
    protected void setUp() {
        this.validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        this.validator = null;
    }

    @AfterAll
    static void afterAll() {
        validatorFactory.close();
    }

    public static <T> void printViolationsInfo(Set<ConstraintViolation<T>> violations) {
        violations.forEach((violation) -> {
            System.out.println("Message      : " + violation.getMessage());
            System.out.println("LeafBean     : " + violation.getLeafBean());
            System.out.println("Annotation   : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value: " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println("Property Path: " + node.getName()));
            System.out.println("<========================================>");
        });
    }
}
