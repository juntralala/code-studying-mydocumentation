package com.juntralala.validator;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testCreateValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory(); // <- otomatis mendeteksi dependecy validator yang terinstall, jika dependency validator kita hapus maka error (disini kita menggunakan hibernate-validator)

        Validator validator = validatorFactory.getValidator();
        Assertions.assertNotNull(validator);

        validatorFactory.close();
    }

}
