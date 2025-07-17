/**
 * Secara default, mysql membuat root user sebagai user administrator
 * Namun best practice nya, saat menjalankan MySQL dengan aplikasi yang kita buat, sangat tidak disarankan menggunakan user root
 * Lebih baik kita buat user khusus untuk tiap aplikasi, bahkan kita bisa batasi hak akses user tersebut, seperti hanya bisa 
   melakukan SELECT, dan tidak boleh melakukan INSERT, UPDATE, atau DELETE
*/

