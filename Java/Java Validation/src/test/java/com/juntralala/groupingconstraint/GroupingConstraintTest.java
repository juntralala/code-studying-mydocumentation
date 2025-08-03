package com.juntralala.groupingconstraint;

import com.juntralala.MyTest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.Test;

public class GroupingConstraintTest extends MyTest {

    @Test
    public void testGroupingConstriantCreditCard() {
        var payment = new Payment();
        payment.setId("B0002");
        payment.setAmount(20_000_000L);
        payment.setCreditCard("tidak valid");
        payment.setVirtualAccount("tidak valid");

        var violations = validator.validate(payment, CreditCardPaymentGroup.class); // <- Virtual Account tidak divalidasi karna bukan group CreditCardPaymentGroup.class
        violations.forEach(System.out::println);
    }

    @Test
    public void testGroupingConstriantVirtualAccount() {
        var payment = new Payment();
        payment.setId("B0002");
        payment.setAmount(20_000_000L);
        payment.setCreditCard("tidak valid");
        payment.setVirtualAccount("tidak valid");

        var violations = validator.validate(payment, VirtualAccountPaymentGroup.class);
        violations.forEach(System.out::println);
    }


}
/**
 * Untuk grouping kita harus membuat interface
 * biasanya hanya interface kosong saja, karna hanya untuk flagging saja
 */

// contoh =============
@Data
@NoArgsConstructor
class Payment {

    @NotBlank(message = "Id can't blank", groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private String id;
    @NotNull(groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    @Range(min = 10_000_000, max = 1_000_000_000, message = "amount must between 1000 and 1000000000", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private Long amount;

    @NotBlank(message = "credit card must not blank", groups = {CreditCardPaymentGroup.class})
    @LuhnCheck(message = "credit card must be valid number", groups = {CreditCardPaymentGroup.class})
    private String creditCard;

    @NotBlank(message = "Virtual Account can't blank", groups = {VirtualAccountPaymentGroup.class})
    private String virtualAccount;

}


// groups
interface CreditCardPaymentGroup {
}
interface VirtualAccountPaymentGroup {
}
