# Programatic Transaction
* Fitur Declarative Transaction sangat mudah untuk digunakan, karena hanya butuh menggunakan annotation
* Namun pada beberapa kasus, misal kode yang kita buat butuh jalan secara async misal nya, maka Declarative Transaction tidak akan berjalan, mau tidak mau biasanya kita akan melakukan manual transaction management lagi
* Kita bisa gunakan cara lama menggunakan Entity Manager, atau kita bisa menggunakan fitur Spring untuk melakukan management transaction secara manual
* Ada beberapa cara untuk melakukan programmatic transaction di Spring