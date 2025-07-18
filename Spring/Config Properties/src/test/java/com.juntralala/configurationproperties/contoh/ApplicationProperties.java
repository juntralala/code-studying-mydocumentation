package com.juntralala.configurationproperties.contoh;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private String name;
    private int version;
    private boolean productionMode;
}
