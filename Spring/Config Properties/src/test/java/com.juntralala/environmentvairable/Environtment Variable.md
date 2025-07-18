# Environment Variable
* Saat kita menggunakan external properties file, properties file yang ada di dalam Jar tidak akan digunakan
* Hal ini menyebabkan kita harus menulis ulang semua properties key yang ada di properties file, dan kadang jika isinya terlalu banyak, ini sangat menyulitkan
* Spring Boot juga mendukung mengambil properties dari environment variable
* Hal ini membuat kita lebih mudah, karena tidak harus semua properties dibuat ulang di file external properties, cukup yang dibutuhkan aja
* Selain itu, kita juga bisa membuat default value ketika environment variable nya tidak ada
