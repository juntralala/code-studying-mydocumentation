# Locking
Dalam relational database, locking adalah aksi untuk mencegah data berubah dalam jeda waktu kita membaca data dan menggunakan data.  
Terdapat dua jenis locking, Optimistic dan Pessimistic.
1. Optimistic Locking
2. Pessimistic Locking

## Optimistic Locking
* Optimistic Locking diimplementasikan dengan cara menambah versi data pada Class Entity untuk memberitahu jika terjadi perubahan data pada Entity
* Pada saat transaksi melakukan commit, trasaksi akan melakukan pengecekan versi terlebih dahulu, jika ternyata versi telah berubah di database, secara otomatis transaksi akan melakukan rollback
* Optimistic Locking sangat cepat karena tidak butuh melakukan lock data, sehingga tidak perlu menunggu transaksi yang melakukan lock
* Konsekuensinya, Pada Optimistic Locking, transaksi akan sering melakukan rollback jika ternyata data yang di commit sudah berubah

### Version Cloumn
* Saat menggunakan Optimistic Locking, kita wajib membuat version column yang digunakan sebagai tanda perubahan yang sudah terjadi di data
* JPA mendukung dua jenis tipe data version, Number (Integer, Short, Long) dan Timestamp (java.sql.Timestamp, java.time.Instant)
* Untuk menandai bahwa attribute tersebut adalah version column, kita perlu menambahkan annotation Version 
* https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/version 
* JPA akan secara otomatis mengupdate attribut version setiap kali kita melakukan update data tersebut

## Pessimistic Locking
* Pada Optimistic Locking, pengecekan versi data dilakukan ketika melakukan commit
* Pada Pessimistic Locking, data akan di lock ketika di select, dan ini menjadikan transaksi lain tidak bisa mengubah data sampai transaksi yang pertama melakukan lock selesai melakukan commit transaksi
* JPA Mendukung banyak jenis tipe Lock, namun tetap saja, itu tergantung ke database yang digunakan, bisa saja database yang digunakan tidak mendukung semua jenis Lock yang terdapat di JPA
* Semua jenis Lock terdapat di enum LockModeType
* https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/lockmodetype 

### Lock Mode Type
| Lock Mode Type                     | Keterangan                                                                                                 |
|------------------------------------|------------------------------------------------------------------------------------------------------------|
| NONE                               | Tidak ada lock, semua lock terjadi di akhir transaksi ketika data di update                                |
| READ / OPTIMISTIC                  | Versi entity akan di cek di akhir transaksi (ini adalah Optimistic Locking)                                |
| WRITE / OPTIMISTIC_FORCE_INCREMENT | Versi entity akan dinaikkan secara otomatis walaupun data tidak di update                                  |
| PESSIMISTIC_FORCE_INCREMENT        | Entity akan di lock secara pessimistic, dan versi akan dinaikkan walaupun data tidak di update             |
| PESSIMISTIC_READ                   | Entity akan di lock secara pessimistic menggunakan shared lock (jika database mendukung), SELECT FOR SHARE |
| PESSIMISTIC_WRITE                  | Entity akan di lock secara explicit, SELECT FOR UPDATE                                                     |
