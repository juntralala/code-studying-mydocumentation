package org.juntralala.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.juntralala.helper.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;

public class PalindromeValidator implements ConstraintValidator<Palindrome, String> {

    private StringHelper stringHelper;

    @Autowired
    public void injection(StringHelper stringHelper) {
        this.stringHelper = stringHelper;
    }

    @Override
    public boolean isValid(String word, ConstraintValidatorContext context) {
        if (word == null) return true;
        return stringHelper.isPalindrome(word);
    }

}
