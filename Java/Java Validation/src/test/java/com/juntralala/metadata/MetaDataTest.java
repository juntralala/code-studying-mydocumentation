package com.juntralala.metadata;

import com.juntralala.MyTest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

public class MetaDataTest extends MyTest {
    @Test
    void metadata() {
        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);

        for (PropertyDescriptor constrainedProperty : beanDescriptor.getConstrainedProperties()) {
            System.out.println(constrainedProperty.getPropertyName());
            for (ConstraintDescriptor<?> constraintDescriptor : constrainedProperty.getConstraintDescriptors()) {
                System.out.println(constraintDescriptor);
            }
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

