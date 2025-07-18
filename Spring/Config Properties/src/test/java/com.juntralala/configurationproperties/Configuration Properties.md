# Configuration Properties
* Spring Boot memiliki sebuah fitur canggih bernama Configuration Properties
* Fitur ini bisa digunakan melakukan binding secara otomatis key yang ada di application properties ke Java Bean property secara otomatis
* Namun untuk menggunakan fitur ini, kita perlu menambahkan dependency yang dibutuhkan, yaitu spring-boot-configuration-processor

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```