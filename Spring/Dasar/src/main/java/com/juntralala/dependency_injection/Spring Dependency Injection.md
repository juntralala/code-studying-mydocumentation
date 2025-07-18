# Spring Dependency Injection
* Spring sejak awal dikenal dengan framework untuk Dependency Injection
* Ketika kita membuat method untuk bean di Spring, kita bisa menambahkan parameter 
* Secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut
* Jika ternyata tidak ada bean yang cocok, maka secara otomatis akan terjadi error
* Dan jika ternyata terdapat bean lebih dari satu, secara otomatis akan terjadi error, kecuali terdapat primary bean


> contohnya di DependencyInjectionConfiguration.java  
> dan aksesnya di DependencyInjectionTest