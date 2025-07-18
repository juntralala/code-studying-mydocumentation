# Test Property Source
* Saat membuat unit test, kadang-kadang kita ingin menggunakan properties file yang berbeda untuk mencoba skenario yang berbeda
* Hal ini agak sulit jika dilakukan dengan menggunakan Annotation PropertySource
* Untungnya di Spring sudah disediakan Annotation TestPropertySource untuk kebutuhan ini, jadi kita bisa menggunakan properties file yang kita mau di unit test
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/TestPropertySource.html 
* Jika membutuhkan properties file lebih dari satu, kita bisa gunakan annotation TestPropertySources
