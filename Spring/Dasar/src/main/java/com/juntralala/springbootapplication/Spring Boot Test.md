# Spring Boot Test
* Untuk membuat unit test di Spring Boot, kita bisa menggunakan annotation @SpringBootTest(classes={YourConfiguration.class})
* Selanjutnya kita tidak perlu mengambil bean secara manual lagi menggunakan ApplicationContext, kita bisa menggunakan DI secara langsung di unit test nya menggunakan @Autowired
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html 

> contohnya di FooApplicationTest