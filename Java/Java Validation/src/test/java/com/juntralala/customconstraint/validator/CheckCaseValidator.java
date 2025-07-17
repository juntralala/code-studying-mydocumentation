package com.juntralala.customconstraint.validator;

import com.juntralala.customconstraint.constraint.CheckCase;
import com.juntralala.customconstraint.enums.CaseMode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true; // skip validasi jika data null

        if (this.caseMode.equals(CaseMode.UPPER)) {
            return value.equals(value.toUpperCase());
        } else if (this.caseMode.equals(CaseMode.LOWWER)) {
            return value.equals(value.toLowerCase());
        }

        return false;
    }
}
