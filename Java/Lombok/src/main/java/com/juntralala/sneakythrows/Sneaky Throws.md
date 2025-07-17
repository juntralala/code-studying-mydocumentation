## Sneaky Throws
* Secara default saat kita membuat kode yang memiliki checked exception, kita perlu menangkapnya dalam try-catch
* Lombok bisa secara pindah mengubah checked exception menjadi runtime exception tanpa mengubah exception nya itu sendiri
* Lombok hanya mengakali agar compiler Java tidak komplen ketika kita tidak menangkap checked exception
* Untuk melakukan itu, kita bisa menggunakan annotation @SneakyThrows
