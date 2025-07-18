package com.juntralala.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.juntralala.import_" // <- akan import semua configuraion yang ada di package ini
})
public class ComponentScanConfiguration {
}
