# Repository Transaction
* Secara default, saat kita membuat Repository interface, Spring akan membuat sebagai instance turunan dari SimpleJpaRepository
* Oleh karena itu, saat kita melakukan CRUD, kita tidak perlu melakukan didalam Transaction, hal ini karena sudah ditambahkan annotation di class SimpleJpaRepository
* Class SimpleJpaRepository terdapat annontatio @Transactional(readOnly=true), oleh karena itu saat kita buat Query Method di Repository, maka secara default akan menjalankan transaction read only
* https://docs.spring.io/spring-data/data-jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html 
