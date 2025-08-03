package com.juntralala.configurationproperties.complexconfigurationproperties.contoh;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@Getter
@Setter
class ApplicationProperties {
    private String name;
    private int version;
    private boolean productionMode;
    private DatabaseProperties database;

    @Getter
    @Setter
    public static class DatabaseProperties {
        private String url;
        private String database;
        private String username;
        private String password;
    }
}
