/** Kenapa perlu Transaction?
 * Saat membuat aplikasi berbasis database, jarang sekali kita akan melakukan satu jenis perintah SQL per aksi yang dibuat aplikasi
 * Contoh, ketika membuat toko online, ketika customer menekan tombol Pesan, banyak yang harus kita lakukan, misal
   - Membuat data pesanan di tabel order
   - Membuat data detail pesanan di tabel order detail
   - Menurunkan quantity di tabel produk
   - Dan yang lainnya
 * Artinya, bisa saja dalam satu aksi, kita akan melakukan beberapa perintah sekaligus
 * Jika terjadi kesalahan di salah satu perintah, harapannya adalah perintah-perintah sebelumnya dibatalkan, agar data tetap konsisten
*/

/** Database Transaction
 * Database transaction adalah fitur di DBMS dimana kita bisa memungkinan beberapa perintah dianggap menjadi sebuah kesatuan perintah yang kita sebut transaction
 * Jika terdapat satu saja proses gagal di transaction, maka secara otomatis perintah-perintah sebelumnya akan dibatalkan
 * Jika sebuah transaction sukses, maka semua perintah akan dipastikan sukses
 */

/**
    +===================+===============================================================================+
    | Perintah          |                                                                               |
    +-------------------+-------------------------------------------------------------------------------+
    | START TRANSACTION | Memulai proses transaksi, proses selanjutnya akan dianggap transaksi sampai   |
    |                   |   perintah COMMIT atau ROLLBACK                                               |
    | COMMIT            | Menyimpan secara permanen seluruh proses transaksi                            |
    | ROLLBACK          | Membatalkan secara permanen seluruh proses transaksi                          |
    +===================+===============================================================================+
*/

/** Yang Tidak Bisa Menggunakan Transaction
 * Perintah DDL (Data Definition Language) tidak bisa menggunakan fitur transaction
 * DDL adalah perintah-perintah yang digunakan untuk merubah struktur, seperti membuat tabel, menambah kolom,
    menghapus tabel, menghapus database, dan sejenisnya
 * Transaction hanya bisa dilakukan pada perintah DML (Data Manipulation Language), seperti operasi INSERT, UPDATE dan DELETE
*/

