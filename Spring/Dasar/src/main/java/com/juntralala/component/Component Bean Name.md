# Component Bean Name
* Saat kita menggunakan @Component, nama bean akan secara otomatis dibuat otomatis oleh Spring 
* Jika kita menggunakan @ComponentScan, secara otomatis bean name secara otomatis akan menggunakan nama class namun menjadi camelCase, misal CategoryService menjadi categoryService, ProductWeb menjadi productWeb
* Jika kita menggunakan @Import, secara otomatis bean name akan menjadi return dari NamaClass.class.getName()
* Namun jika ingin membuat nama berbeda, kita juga bisa gunakan @Component(value=”namaBean”)

> contoh ketika penamaan sudah ada
> lihat contoh akses bean nya di ComponentTest