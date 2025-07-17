/** Locking Instance
 * LOCK INSTANCE adalah perintah locking yang membuat perintah DDL akan diminta
   menuggu sampai proses UNLOCK INSTANCE 
 * Biasanya proses Locking Instance ini terjadi ketika misal kita ingin melakukan
   backup data, agar tidak terjadi perubahan terhadap struktur table misalnya,
   kita bisa menggunakan locking instance  
 * Setelah proses backup selesai, baru kita unlock instance nya
 * Untuk melakukan locking instance, kita gunakan perintah :
   - LOCK INSTANCE FOR BACKUP;
 * Untuk melakukan unlock instance, kita bisa menggunakan perintah :
   - UNLOCK INSTANCE;
*/

LOCK INSTANCE FOR BACKUP;

UNLOCK INSTANCE;