package com.juntralala.constraintdescriptor;

import com.juntralala.MyTest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;

public class ConstraintDescriptorTest extends MyTest {

    @Test
    void constraintDescriptor() {
        Person person = new Person(null, null);

        var violations = validator.validate(person);
        violations.forEach(violation -> { // masih banyak lagi informasi selain yang ditampilkan dibawah ini dengan ConstraintDescriptor
            System.out.println("Annotation      : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Attributes      : " + violation.getConstraintDescriptor().getAttributes());
            System.out.println("Payload         : " + violation.getConstraintDescriptor().getPayload());
            System.out.println("Groups          : " + violation.getConstraintDescriptor().getGroups());
            System.out.println("Message Template: " + violation.getConstraintDescriptor().getMessageTemplate());
            System.out.println("<=========================================================>");
        });
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
