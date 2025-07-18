# Query Relation
* Saat kita belajar JPA, kita bisa melakukan query ke relasi Entity atau Embedded field secara otomatis menggunakan tanda . (titik)
* Di Spring Data Repository, kita bisa gunakan _ (garis bawah) untuk menyebutkan bahwa itu adalah tanda . (titik) nya
* Misal ProductRepository.findAllByCategory_Name(String)
