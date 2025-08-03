package com.juntralala.crossparameterconstraint;

import com.juntralala.MyTest;
import com.juntralala.crossparameterconstraint.service.UserService;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class CrossParameterConstraintTest extends MyTest {

    @Test
    public void testCrossParameterConstraint() throws NoSuchMethodException {
        UserService userService = new UserService();
        Class<? extends UserService> userServiceClass = userService.getClass();
        Method register = userServiceClass.getMethod("register", String.class, String.class, String.class);

        ExecutableValidator executableValidator = validator.forExecutables();
        var violations = executableValidator.validateParameters(userService, register, new Object[]{"username", "rahasia", "rahasia123"});

        violations.forEach(violation -> {
            System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
        });
    }

}
