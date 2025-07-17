package com.juntralala.getter_setter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Login {

    @Setter(value = AccessLevel.PROTECTED)
    private String username;

    @Setter(value = AccessLevel.PROTECTED)
    private String password;

}
