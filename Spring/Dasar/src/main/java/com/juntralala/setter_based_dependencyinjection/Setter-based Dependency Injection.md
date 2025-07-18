# Setter-based Dependency Injection
* Selain menggunakan constructor parameter, kita juga bisa menggunakan setter method jika ingin melakukan dependency injection
* Namun khusus untuk setter method, kita perlu menambah annotation @Autowired pada setter method nya
* Secara otomatis Spring akan mencari bean yang dibutuhkan di setter method yang memiliki annotation @Autowired
* Setter-based DI juga bisa digabung dengan Constructor-based DI
