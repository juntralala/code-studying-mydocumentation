package org.juntralala.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.juntralala.validation.Palindrome;

@Data
@AllArgsConstructor
public class Foo {

    @Palindrome
    private String foo;

}
