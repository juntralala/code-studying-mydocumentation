package com.juntralala.groupconversion.contoh;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
class Payment {
    @NotBlank(message = "Id can't blank", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private String id;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    @Range(min = 10_000_000, max = 1_000_000_000, message = "amount must between 1000 and 1000000000", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private Long amount;

    @NotBlank(message = "credit card must not blank", groups = {CreditCardPaymentGroup.class})
    @LuhnCheck(message = "credit card must be valid number", groups = {CreditCardPaymentGroup.class})
    private String creditCard;

    @NotBlank(message = "Virtual Account can't blank", groups = {VirtualAccountPaymentGroup.class})
    private String virtualAccount;

    @NotNull(message = "customer must not null")
    @Valid
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;
}
