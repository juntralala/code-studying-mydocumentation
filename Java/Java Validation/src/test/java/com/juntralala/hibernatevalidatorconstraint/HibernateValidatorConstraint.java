package com.juntralala.hibernatevalidatorconstraint;

import com.juntralala.MyTest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraint extends MyTest {

    @Test
    @DisplayName("Constraint tambahan yang disediakan Hibernate diluar Bean Validation")
    public void testHibernateValidatorConstraint() {
        Payment payment = new Payment("B0001", 10_000_000_000L, "41111111");

        var violations = validator.validate(payment);

        violations.forEach(System.out::println);
    }

}


// ============================================

@Data
@AllArgsConstructor
class Payment {
    @NotBlank(message = "Id can't blank")
    private String id;

    @NotNull
    @Range(min = 10_000_000, max = 1_000_000_000, message = "amount must between 1000 and 1000000000")
    private Long amount;

    @NotBlank(message = "credit card must not blank")
    @LuhnCheck(message = "credit card must be valid number")
    private String creditCard;
}