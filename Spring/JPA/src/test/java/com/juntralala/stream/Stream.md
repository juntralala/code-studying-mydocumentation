# Stream
* Saat kita menggunakan List<T> dan Query Method findAll…, maka secara otomatis seluruh data hasil dari database akan di load ke memory
* Pada kasus data yang sangat banyak, hal ini sangat berbahaya karena bisa terjadi error OutOfMemory
* Spring Data JPA bisa menggunakan fitur database cursor, untuk mengambil data sedikit demi sedikit ketika diperlukan menggunakan Java Stream
* Kita bisa membuat Query Method dengan prefix streamAll… dan return value Stream<T>
