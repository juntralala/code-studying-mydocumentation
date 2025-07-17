package com.juntralala.crossparameterconstraint.service;

import com.juntralala.crossparameterconstraint.constraint.CheckPasswordParameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(passwordParam = 1, retypePasswordParam = 2)
    public void register(
            @NotBlank(message = "username must not blank") String username,
            @NotBlank(message = "password must not blank") String password,
            @NotBlank(message = "retypePassword must not blank") String retypePassword) {
        // DO REGISTER USER HERE
    }

}
