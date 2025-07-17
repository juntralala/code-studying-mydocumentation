# Constructor Expression
* JPA memiliki fitur dimana kita bisa memanggil constructor sebuah class ketika melakukan select
* Sehingga dibanding menggunakan tipe data Object[], kita bisa mapping field yang kita select, ke constructor sebuah class
* Kita bisa gunakan query : `select new nama.package.Class(field, field, …)`
