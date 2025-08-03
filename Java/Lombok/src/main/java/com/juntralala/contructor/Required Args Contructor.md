## Required Args Contructor
* Saat kita menggunakan @NoArgsConstructor, maka akan dibuatkan constructor tanpa parameter, jika menggunakan @AllArgsConstructor,m maka akan dibuatkan constructor untuk semua parameter
* Kadang-kadang kita hanya ingin membuat constructor untuk parameter yang memang wajib saja.
* Pada kasus ini, kita bisa menggunakan @RequiredArgsConstructor
* Secara otomatis Lombok hanya akan membuat constructor dengan parameter untuk field yang final
