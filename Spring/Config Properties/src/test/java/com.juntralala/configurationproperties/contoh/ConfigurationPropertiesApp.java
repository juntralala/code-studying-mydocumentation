package com.juntralala.configurationproperties.contoh;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ApplicationProperties.class // <- harus di daftarkan agar bisa digunakan pada aplikasi springboot
})
public class ConfigurationPropertiesApp {
}
