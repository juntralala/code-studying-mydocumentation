# Spesification Executor.md
* Di JPA, terdapat fitur Criteria untuk membuat Query secara dinamis
* Hal ini bisa kita gunakan fitur Specification di Spring Data JPA
* Untuk mendukung fitur ini, Repository yang kita buat harus extends JpaSpeficitaionExecutor, dimana terdapat banyak sekali method dengan parameter Specification
* https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaSpecificationExecutor.html 
