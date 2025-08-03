# Data Source
* Salah satu keuntungan menggunakan Spring Data JPA dan Spring Boot adalah, semua upacara yang biasa kita lakukan ketika menggunakan JPA, sudah dilakukan oleh Spring Boot
* Jadi kita tidak perlu membuat DataSource secara manual, karena sudah otomatis dibuat oleh Spring Boot 
* https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/jdbc/DataSourceAutoConfiguration.java 
* Untuk mengubah konfigurasi DataSource, kita cukup menggunakan application properties saja
* Kita bisa lihat semua konfigurasinya dengan prefix spring.datasource.*
* https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.data 
