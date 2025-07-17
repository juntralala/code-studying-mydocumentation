package com.juntralala.classlevelconstraint.data;

import com.juntralala.classlevelconstraint.constraint.CheckPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@CheckPassword(message = "password must be same with retype password")
public class Register {

    @NotBlank(message = "username can't blank")
    private String username;

    @NotBlank(message = "password can't blank")
    private String password;

    @NotBlank(message = "retypePassword can't blank")
    private String retypePassword;

}
