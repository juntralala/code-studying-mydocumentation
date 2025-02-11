# Component
* Sebelumnya kita sudah belajar membuat bean menggunakan method di configuration dengan annotation @Bean
* Spring juga menyediakan cara otomatis tanpa harus kita membuat method @Bean
* Kita bisa menandai sebuah class dengan annotation @Component, secara otomatis Spring akan membuatkan bean untuk class tersebut
* @Component hanya mendukung pembuatan satu bean, jadi jika kita ingin membuat beberapa bean dengan tipe yang sama, kita tetap harus menggunakan @Bean method
