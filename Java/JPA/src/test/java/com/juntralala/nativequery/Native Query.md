# Native Query
* Pada kasus tertentu, kadang ada Query yang akhirnya harus dibuat langsung spesifik menggunakan SQL database yang kita gunakan
* Walaupun hal ini tidak disarankan, karena bisa membuat kita kesulitan ketika akan mengubah database yang sedang digunakan, namun fitur ini juga bisa dilakukan di JPA
* Kita bisa menggunakan method `EntityManager.createNativeQuery(query, class)`