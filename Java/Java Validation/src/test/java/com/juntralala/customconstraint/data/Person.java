package com.juntralala.customconstraint.data;

import com.juntralala.customconstraint.constraint.CheckCase;
import com.juntralala.customconstraint.enums.CaseMode;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    @NotBlank
    @CheckCase(mode = CaseMode.UPPER)
    private String name;

}
