package com.juntralala.groupconversion.contoh;

import com.juntralala.MyTest;
import org.junit.jupiter.api.Test;

public class GroupConversionTest extends MyTest {

    @Test
    void groupConversion() {
        var customer = new Customer();
        var payment = new Payment();
        payment.setId("B0001");
        payment.setAmount(20_000_000L);
        payment.setCreditCard("10000");
        payment.setCustomer(customer);

        var violations = validator.validate(payment, CreditCardPaymentGroup.class);

        printViolationsInfo(violations);
    }

}
