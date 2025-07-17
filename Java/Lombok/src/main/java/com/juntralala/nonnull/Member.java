package com.juntralala.nonnull;

import lombok.Data;
import lombok.NonNull;

@Data
public class Member {

    @NonNull
    private String id;
    @NonNull
    private String name;

    public String sayHello(@NonNull String name) {
        return "Hello " + name + ", My Name is" + this.name;
    }

}
