package com.juntralala.configurationproperties.collectionconfigurationproperties.contoh;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("application")
@Getter
@Setter
class ApplicationProperties {
    private String name;
    private int version;
    private boolean productionMode;
    private DatabaseProperties database;

    private List<Role> defaultRoles;
    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class DatabaseProperties {
        private String url;
        private String database;
        private String username;
        private String password;
        private List<String> whitelistTables;
        private Map<String, Integer> maxTablesSize;
    }

    @Setter
    @Getter
    public static class Role {
        private String id;
        private String name;
    }
}
