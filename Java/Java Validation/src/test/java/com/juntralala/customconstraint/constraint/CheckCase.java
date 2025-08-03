package com.juntralala.customconstraint.constraint;

import com.juntralala.customconstraint.enums.CaseMode;
import jakarta.validation.Constraint;
import com.juntralala.customconstraint.validator.CheckCaseValidator;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckCaseValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "the case of string is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
