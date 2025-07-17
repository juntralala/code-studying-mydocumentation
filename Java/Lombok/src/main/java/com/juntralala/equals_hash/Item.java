package com.juntralala.equals_hash;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = "createdAt")
@Getter
@Setter
public class Item {

    private String id;
    private String value;
    private String createdAt;

}
