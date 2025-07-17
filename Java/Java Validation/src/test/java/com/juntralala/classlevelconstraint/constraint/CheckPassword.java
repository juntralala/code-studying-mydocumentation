package com.juntralala.classlevelconstraint.constraint;

import com.juntralala.classlevelconstraint.validator.CheckPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckPasswordValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface CheckPassword {

    String message() default "password have to same with retypePassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
