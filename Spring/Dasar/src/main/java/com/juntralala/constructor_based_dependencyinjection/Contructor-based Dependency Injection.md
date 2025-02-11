# Constructor-based Dependency Injection
* Sebelumnya untuk melakukan Dependency Injection di @Bean, kita bisa menambah parameter di method nya
* Secara otomatis Spring akan memilih bean mana yang cocok untuk parameter tersebut
* Bagaimana jika menggunakan @Component?
* Untuk @Component kita bisa melakukan beberapa cara untuk Dependency Injection nya


* Pertama yang bisa kita lakukan untuk Dependency Injection di @Component adalah menggunakan constructor parameter
* Kita bisa menambahkan constructor yang memiliki parameter jika membutuhkan bean lain
* Secara otomatis Spring akan mencarikan bean tersebut, dan ketika membuat bean @Component, Spring akan menggunakan bean yang dibutuhkan di constructor
* Constructor-based Dependency Injection hanya mendukung satu constructor, jadi pastikan kita hanya membuat satu constructor

> cara lainnya adalah Setter-based Dependecy Injection dan Field-based dependency Injection
 
