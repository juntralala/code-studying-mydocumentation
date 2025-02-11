package com.juntralala.classlevelconstraint;

import com.juntralala.MyTest;
import com.juntralala.classlevelconstraint.data.Register;
import org.junit.jupiter.api.Test;

public class ClassLevelConstraintTest extends MyTest {

    @Test
    void testClassLevel() {
        Register register = new Register("admin", "rahasia", "rahasia1234");

        var violations = validator.validate(register);
        printViolationsInfo(violations);
    }

}
