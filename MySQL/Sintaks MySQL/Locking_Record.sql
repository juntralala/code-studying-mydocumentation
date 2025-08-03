
/** Locking Record
 * Saat kita melakukan proses TRANSACTION, lalu kita melakukan proses perubahan data, data yang kita ubah tersebut akan secara
   otomatis di LOCK 
 * Hal ini membuat proses TRANSACTION sangat aman
 * Oleh karena itu, sangat disarankan untuk menggunakan fitur TRANSACTION ketika memanipulasi data di database, terutama ketika
   perintah manipulasinya lebih dari satu kali 
 * Locking ini akan membuat sebuah proses perubahan yang akan dilakukan oleh pihak lain akan diminta untuk menunggu
 * Data akan di lock samapai kita melakukan COMMIT atau ROLLBACK transaksi tersebut
*/