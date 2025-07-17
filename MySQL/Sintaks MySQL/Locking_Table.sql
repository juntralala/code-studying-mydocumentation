/** Locking Table
 * MySQL mendukung proses locking terhadap sebuah table
 * Jika kita me-lock table, maka satu seluruh data di table tersebut akan dilock
 * Ada 2 jenis lock table, yaitu READ dan WRITE
 * Cara melakukan locking table adalah dengan perintah
   > LOCK TABLES nama_table READ;
   > LOCK TABLES nama_table WRITE;
 * Setelah selesai melakukan lock table, kita bisa melakukan unlock dengan perintah : 
   > UNLOCK TABLES;
*/

/** Behavior Lock Tables
 * Perintah   * Proses yang Melakukan Lock        * Proses lain
   READ         Hanya bisa melakukan read           Hanya bisa melakukan read terhadap table tersebut,
                terhadap table tersebut             tidak bisa melakukan write
   WRITE        Bisa melakukan read dah write       Tidak bisa melakukan read dan Write pada table tersebut
                terhadap table tersebut 
*/

-- <=========> Contoh READ <=========>
-- user 1
LOCK TABLES guestbooks READ;

select * from guestbooks; -- langsung dijalankan

-- user 2
select * from guestbooks; -- langsung dijalankan



-- <=========> Contoh WRITE <=========>
-- user 1
LOCK TABLES guestbooks WRITE;

select * from guestbooks; -- langsung dijalankan

-- user 2
select * from guestbooks; -- menunggu sampe unlock tables