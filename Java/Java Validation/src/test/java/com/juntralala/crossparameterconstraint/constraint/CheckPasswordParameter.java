package com.juntralala.crossparameterconstraint.constraint;

import com.juntralala.crossparameterconstraint.validator.CheckPasswordParameterValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckPasswordParameterValidator.class)
@Target({METHOD, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();
    int retypePasswordParam();

    String message() default "password is not same with retypePassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
