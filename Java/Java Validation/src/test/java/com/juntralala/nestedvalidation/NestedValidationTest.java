package com.juntralala.nestedvalidation;

import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NestedValidationTest {

    private Validator validator;

    @BeforeEach
    protected void setUp() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testNestedValidation() {
        var address = new Address(null, null, null);
        var person = new Person("ujun", "mantap", address);

        var violations = validator.validate(person);

        Assertions.assertEquals(3, violations.size());
        violations.forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
class Person {
    @NotBlank(message = "First name can not blank")
    @Size(max = 20, message = "First name max length must 100 characters")
    private String firstName;

    @NotBlank(message = "Last name can not blank")
    @Size(max = 20, message = "Last name max length must 100 characters")
    private String lastName;

    @NotNull(message = "Message can't null")
    @Valid
    private Address address;
}

@Data
@AllArgsConstructor
class Address {
    @NotBlank(message = "Street can't blank")
    private String street;

    @NotBlank(message = "City can't blank")
    private String city;

    @NotBlank(message = "Country can't blank")
    private String country;
}