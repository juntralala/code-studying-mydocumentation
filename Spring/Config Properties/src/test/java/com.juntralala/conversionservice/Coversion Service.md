# Conversion Service
* Conversion Service merupakan inti dari logic untuk melakukan konversi tipe data di Spring
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html 
* Saat kita membuat custom converter, maka kita harus registrasikan ke conversion service
* Kita tidak perlu membuat Conversion Service secara manual, karena implementasi class nya sudah disediakan oleh Spring, yaitu ApplicationConversionService
* Jika membuat aplikasi berbasis Web, kita tidak perlu melakukannya secara manual, karena sudah otomatis ada di Spring Boot Web, namun karena sekarang kita belum belajar Spring Boot Web, jadi kita perlu membuat Conversion Service secara manual
