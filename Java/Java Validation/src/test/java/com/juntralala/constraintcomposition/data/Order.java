package com.juntralala.constraintcomposition.data;

import com.juntralala.constraintcomposition.constraint.CheckOrderId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class Order {

    @CheckOrderId
    private String id;

    @NotNull
    @Range(min = 10_000L, max = 100_000_000_000L)
    private Long amount;
}
