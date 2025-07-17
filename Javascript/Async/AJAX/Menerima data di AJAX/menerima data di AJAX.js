/** Menerima Data di AJAX
 * AJAX biasanya digunakan untuk mengirim data ke Server atau menerima data dari Server 
 * Tiap request AJAX yang dilakukan, biasanya kita ingin mendapatkan informasi response yang diberikan Server
 * Kita tidak bisa langsung mengambil reponse AJAX, karena proses AJAX adalh Async, sehingga kita perlu
   menuggu sampai proses Async nya selesai
 * Untuk mendapatkan informasi AJAX, kira bisa menggunakan AJAX Callback, yang akan dieksekusi setelah
   proses AJAX selesai
 * Untuk menambahkan AJAX Callback, kita bisa tambahkan pada event load
 * https://developer.mozilla.org/docs/Web/API/XMLHttpRequest/load_event
 * Dan untuk mengambil datanya dari server, kita bisa menggunakan propertu response Text
 */
