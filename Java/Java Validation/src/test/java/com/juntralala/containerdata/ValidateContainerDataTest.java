package com.juntralala.containerdata;

import com.juntralala.MyTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class ValidateContainerDataTest extends MyTest {

    @Test
    void validateContainerData() {
        Person person = new Person("ujun", List.<String>of("Coding", "Gaming", "", ""));

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());
        printViolationsInfo(violations);
    }

}

@Data
@AllArgsConstructor()
class Person {

    @NotBlank
    private String name;

    private List<@NotBlank(message = "hobbies can't blank") String> hobbies;

}
