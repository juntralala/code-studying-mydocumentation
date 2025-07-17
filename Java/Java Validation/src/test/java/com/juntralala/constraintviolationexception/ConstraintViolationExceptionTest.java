package com.juntralala.constraintviolationexception;

import com.juntralala.MyTest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

public class ConstraintViolationExceptionTest extends MyTest {

    @Test
    void constraintViolationException() {
        try {
            var person = new Person(null, "");
            var violations = validator.validate(person);

            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }
    }

}

@Getter
@Setter
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
}
