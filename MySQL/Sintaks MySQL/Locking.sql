/** Fitur Locking
 * Locking adalah proses mengunci data di DBMS
 * Proses mengunci data sangat penting dilakukan, salah satunya agar data benar-benar terjamin konsistensinya
 * Karena pada kenyataannya, aplikasi yang akan kita buat pasti digunakan oleh banyak pengguna, dan banyak pengguna tersebut bisa
   saja mengakses data yang sama, jika tidak ada proses locking, bisa dipastikan akan terjadi RACE CONDITION, yaitu proses balapan 
   ketika mengubah data yang sama
 * Contoh saja, ketika kita belanja ditoko online, kita akan balapan membeli barang yang sama, jika data tidak terjaga, bisa jadi
   kita salah mengapadate stock barang    
*/
