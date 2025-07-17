package com.juntralala.methodvalidation;

import com.juntralala.MyTest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodValidationTest extends MyTest {

    @Test
    public void testMethodParamValidationValid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        var person = new Person("ujun", "saja");

        Method method = Person.class.getMethod("sayHello", String.class);
        var violations = executableValidator.validateParameters(person, method, new Object[]{"Udin"});

        printViolationsInfo(violations);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void testMethodParamValidationInvalid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        var person = new Person("ujun", "saja");

        Method method = Person.class.getMethod("sayHello", String.class);
        var violations = executableValidator.validateParameters(person, method, new Object[]{null});

        printViolationsInfo(violations);
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    public void testMethodReturnValidationValid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        var person = new Person("ujun", "saja");
        Method method = Person.class.getMethod("getFullName");

        String returnValue = person.getFullName();
        var violations = executableValidator.validateReturnValue(person, method, returnValue);

        printViolationsInfo(violations);
        Assertions.assertEquals(0, violations.size());
    }


    @Test
    public void testMethodReturnValidationInvalid() throws NoSuchMethodException {
        var executableValidator = validator.forExecutables();
        var person = new Person("", "");

        String returnValue = person.getFullName();
        Method method = Person.class.getMethod("getFullName");
        var violations = executableValidator.validateReturnValue(person, method, returnValue);

        printViolationsInfo(violations);
        Assertions.assertEquals(1, violations.size());
    }

}

// class data

@Data
@AllArgsConstructor
class Person {

    private String firstName;
    private String lastName;

    public void sayHello(
            @NotBlank(message = "The name parameter can't blank")
            String name) {
        System.out.printf("Hello %s, my name is %s%n", name, firstName);
    }

    @NotBlank
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
