package com.juntralala.crossparameterconstraint.validator;

import com.juntralala.crossparameterconstraint.constraint.CheckPasswordParameter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {

    private int passwordParam;
    private int reypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        this.passwordParam = constraintAnnotation.passwordParam();
        this.reypePasswordParam = constraintAnnotation.retypePasswordParam();
    }

    @Override
    public boolean isValid(Object[] params, ConstraintValidatorContext constraintValidatorContext) {
        String password = (String) params[passwordParam];
        String retypePassword = (String) params[reypePasswordParam];

        if (password == null || retypePassword == null) {
            return true; // skip validation
        }

        return password.equals(retypePassword);
    }
}
