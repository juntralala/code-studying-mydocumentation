package com.juntralala.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"price"})
@AllArgsConstructor()
public class Product {

    private final String id;
    private String name;
    private Long price;

}
