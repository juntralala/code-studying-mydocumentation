package com.juntralala.payload.contoh;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

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

    @NotBlank(message = "Virtual Account can't blank", payload = {EmailErrorPayload.class})
    private String virtualAccount;

}
