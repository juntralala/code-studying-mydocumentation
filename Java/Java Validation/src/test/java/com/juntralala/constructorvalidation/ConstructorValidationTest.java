package com.juntralala.constructorvalidation;

import com.juntralala.MyTest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ConstructorValidationTest extends MyTest {

    @Test
    public void testConstructorParamValidationValid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class);

        var violations = executableValidator.validateConstructorParameters(constructor, new Object[]{"ujun", "saja"});

        printViolationsInfo(violations);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void testConstructorParamValidationInvalid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class);

        var violations = executableValidator.validateConstructorParameters(constructor, new Object[]{"", null});

        printViolationsInfo(violations);
        Assertions.assertEquals(2, violations.size());
    }

    @Test
    public void testConstructorReturnValidationValid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class);

        Person person = new Person("ujun", "saja");

        var violations = executableValidator.validateConstructorReturnValue(constructor, person);

        printViolationsInfo(violations);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void testConstructorReturnValidationInvalid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class);

        Person person = new Person("", "");

        var violations = executableValidator.validateConstructorReturnValue(constructor, person);

        printViolationsInfo(violations);
        Assertions.assertEquals(2, violations.size());
    }
}

@Getter
@Setter
class Person {

    @NotBlank(message = "firstName field can't blank")
    private String firstName;
    @NotBlank(message = "lastName field can't blank")
    private String lastName;

    @Valid
    public Person(
            @NotBlank(message = "firstName parameter can't blank") String firstName,
            @NotBlank(message = "lastName parameter can't blank") String lastName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
