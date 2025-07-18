# Projection
* Saat kita belajar JPA, kita tahu terdapat fitur di JPA QL untuk memanggil constructor sebuah class, sehingga return hasil query bisa dalam bentuk class bukan Entity
* Di Spring, terdapat fitur bernama Projection, yang mirip namun lebih mudah
* Caranya di Repository, kita bisa buat Query Method dengan return Interface yang kita inginkan, secara otomatis nanti Spring Data akan melakukan mapping sesuai dengan field hasil Query dengan Interface return nya
* Yup, tidak salah mengetik, jadi kita harus buat dalam bentuk Interface, bukan Class
* Hal ini agar Spring Data tahu bahwa itu adalah projection
