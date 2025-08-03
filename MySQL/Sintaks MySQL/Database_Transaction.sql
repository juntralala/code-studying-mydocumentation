/** Kenapa butuh database transuction?
 * Saat membuat aplikasi berbasis database, jarang sekali kita akan melakukan satu jenis perintah SQL per aksi yang dibuat aplikasi
 * Contoh, ketika membuat aplikasi toko online, ketika customer menekan tombol pesan, Banyak yang harus kita lakukan, misal
   - Membuat data pesanan di table order
   - Membuat data detail pesanan ditable order detail
   - Menurunkan quantity ditable produk 
   - DLL
 * Artinya, bisa saja dalam satu aksi, kita akan melakukan beberapa perintah sekaligus  
 * Jika terjadi kesalahan di salah satu perintah, harapannyaadalah di perintah sebelum-sebelumnya di batalkan, agar data tetap konsisten
*/

/** Database Transaction 
 * Databasetansaction adalah fitur di DBMS dimana kiat bisa memungkinkan beberapa perintah dianggap menjadi sebuah kesatuan 
   perintah yang kita sebut transaction 
 * Jika terdapat satu saja progres gagal pada transaction, maka secara otomatis perintah-perintah sebelumnya akan dibatalkan 
 * Jika sebuah transaction sukses maka semua perintah akan dipastikan sukses
*/

/** Membuat Transaction
 * START => INSERT => INSERT => UPDATE => COMMMIT
 * START => INSERT => INSERT => UPDATE => ROLLBACK TRANSACTION      -> transaction di batalkan
*/

/** Command Transaction di MySQL
 * START TRANSACTION            -> memulai proses transaksi, proses sebelumnya akan dianggap transaksi sampai perintah
                                   COMMIT atau ROLLBACK   
 * COMMIT                       -> Menyimpan secara permanen seluruh proses transaksi
 * ROLLBACK                     -> Membatalkan secara permanen seluruh transaksi
*/

/** Yang tidak bisa menggunakan Database Transaction  
 * Perintah DDL tidak bisa menggunakan fitur transaction
 * Transaction hanya bisa digunakan/berlaku pada perintah DML, seperti INSERT, UPDATE, atau DELETE
*/

START TRANSACTION;

INSERT INTO guestbooks (email, title, content) VALUES
('contoh@gmail.com', 'Contoh', 'Contoh'),
('contoh2@gmail.com', 'Contoh', 'Contoh'),
('contoh3@gmail.com', 'Contoh', 'Contoh');

-- ketika melakukan transaction
-- sebeleum data dicommit, data yang di insert tidak akan muncul pada user/aplikasi lain 

COMMIT;