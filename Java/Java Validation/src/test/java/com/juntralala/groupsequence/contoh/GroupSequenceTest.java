package com.juntralala.groupsequence.contoh;

import com.juntralala.MyTest;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GroupSequenceTest extends MyTest {

    @Test
    void testGroupSequence() {
        Payment payment = new Payment();
        payment.setId("B0003");
        payment.setAmount(20_000L);
        payment.setCreditCard("2000");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, PaymentGroup.class);

        printViolationsInfo(violations);
    }

}
