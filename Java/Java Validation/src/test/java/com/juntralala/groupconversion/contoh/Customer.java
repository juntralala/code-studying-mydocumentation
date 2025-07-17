package com.juntralala.groupconversion.contoh;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Customer {

    @NotBlank(message = "email must not blank")
    @Email(message = "email must valid format")
    private String email;

    @NotBlank(message = "email must not blank")
    private String name;
}
