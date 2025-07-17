package com.juntralala.constraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintTest {

    @Test
    public void testConstraint() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Person ujun = new Person("ujun", "saja");

        Set<ConstraintViolation<Person>> errors = validator.validate(ujun);

        Assertions.assertEquals(0, errors.size());
    }

    @Test
    public void testValidationFailed() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Person ujun = new Person(null, null);
        Set<ConstraintViolation<Person>> violations = validator.validate(ujun);

        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value: " + violation.getInvalidValue());
            System.out.println("Path: " + violation.getPropertyPath());
        }
    }

}

class Person {
    @NotBlank(message = "First name can not blank")
    @Size(max = 20, message = "First name max length must 100 characters")
    private String firstName;

    @NotBlank(message = "Last name can not blank")
    @Size(max = 20, message = "Last name max length must 100 characters")
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}