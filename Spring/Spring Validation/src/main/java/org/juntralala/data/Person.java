package org.juntralala.data;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class Person {

    @NotBlank
    private String id;

    @NotBlank
    @Length(min = 4, max = 100)
    private String name;
}
