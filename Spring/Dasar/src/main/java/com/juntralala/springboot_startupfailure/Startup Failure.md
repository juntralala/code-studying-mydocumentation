# Startup Failure
* Salah satu yang menarik di Spring Boot adalah, Spring Boot memiliki fitur FailureAnalyzer
* FailureAnalyzer digunakan untuk melakukan analisa ketika terjadi error startup yang menyebabkan aplikasi tidak mau berjalan
* Spring sudah menyediakan banyak sekali class implementasi FailureAnalyzer yang bisa mempermudah kita menganalisa kesalaha ketika terjadi startup failure
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/diagnostics/FailureAnalyzer.html 

> kalau tanpa FailureAnalyzer milik SpringBoot kita harus membaca stack trace Spring secara manual,  
> dan itu merupakan lebih sulit untuk dipahami 
