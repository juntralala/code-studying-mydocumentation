package org.juntralala.data;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@Getter
@Setter
@Component
@Validated
@ConfigurationProperties("database")
public class DatabaseProperties {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
