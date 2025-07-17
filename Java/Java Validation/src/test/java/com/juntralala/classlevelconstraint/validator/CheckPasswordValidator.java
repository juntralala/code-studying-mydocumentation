package com.juntralala.classlevelconstraint.validator;

import com.juntralala.classlevelconstraint.constraint.CheckPassword;
import com.juntralala.classlevelconstraint.data.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext context) {
        if (register.getPassword() == null) return true; // skip validasi

        return register.getPassword().equals(register.getRetypePassword());
    }

}
