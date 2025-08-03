# Repository
* Setiap Entity yang kita buat di JPA, maka kita biasanya akan buatkan Repository nya
* Repository berbentuk Interface, yang secara otomatis diimplementasikan oleh Spring menggunakan AOP
* Untuk membuat Repository, kita cukup membuat interface turunan dari JPARepository<T, ID>
* https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html 
* Dan kita juga bisa tambahkan annotation @Repository (walaupun tidak wajib)
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html 
