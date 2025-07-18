# Distribution File
* Spring Boot plugin juga sudah menyediakan cara membuat distribution file aplikasi kita
* Plugin ini akan mendeteksi main class di project kita, lalu membundle aplikasi kita beserta dependency yang dibutuhkan dalam satu file jar
* Pastikan hanya terdapat satu main class, karena jika lebih dari satu, maka spring boot plugin akan melakukan komplen
* Kita cukup gunakan perintah :  
  mvn package
* Secara otomatis akan terbuat single jar application
