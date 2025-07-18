# Named Query
* Saat kita menggunakan JPA, kita sering sekali menggunakan Named Query
* Lantas bagaimana jika kita menggunakan Spring Data JPA Repository?
* Untuk menggunakan Named Query di Repository, kita cukup buat nama method sesuai degan nama Named Query, misal jika kita memiliki Named Query dengan nama Product.searchProductUsingName, maka kita bisa membuat method ProductRepository.searchProductUsingName()
* Secara otomatis itu akan menggunakan Named Query tersebut
