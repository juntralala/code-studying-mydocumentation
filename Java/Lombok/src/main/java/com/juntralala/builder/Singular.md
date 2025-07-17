## Singular
* Saat membuat builder, secara default kita harus menggunakan object yang diperlukan secara langsung, misal sebelumnya ada field List<String> hobbies, maka kita wajib menambahkan langsung object List nya
* Lombok memiliki fitur @Singular, yang bisa digunakan sebagai helper, sehingga kita tidak perlu langsung membuat List nya
* Lombok akan membuat builder method untuk menambah data ke Collection (List, Set atau Map) nya satu per satu

> Contohnya masih di Person.java