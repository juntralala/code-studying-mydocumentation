## Builder
* Saat membuat object yang kompleks, kadang agak menyulitkan jika harus selalu dibuat menggunakan constructor atau menggunakan setter method
* Lombok memiliki fitur untuk melakukan auto generate class Builder untuk membuat object yang kompleks
* Dengan ini, pembuatan object akan lebih mudah menggunakan class Builder nya
* Caranya, kita cukup gunakan @Builder pada class tersebut
* Lombok akan secara otomatis membuat static method builder() untuk membuat builder objectnya, dan build() untuk membuat object nya
