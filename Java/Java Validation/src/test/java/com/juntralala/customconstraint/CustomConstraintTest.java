package com.juntralala.customconstraint;

import com.juntralala.MyTest;
import com.juntralala.customconstraint.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends MyTest {

    @Test
    public void testCustomConstraint() {
        Person person = new Person("Ozon");
        var violations = validator.validate(person);

        violations.forEach(violation -> System.out.println(violation.getPropertyPath() + ": " + violation.getMessage()));
        Assertions.assertEquals(1, violations.size());
    }
}


