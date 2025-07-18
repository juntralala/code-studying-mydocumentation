# Trancation Propagation
* Saat kita membuat method dengan annotation @Transactional, kita mungkin didalamnya memanggil method @Transactional lainnya
* Pada kasus seperti itu, ada baiknya kita mengerti tentang attribute propagation pada @Transactional
* Kita bisa memilih nilai apa yang ingin kita gunakan
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html 
