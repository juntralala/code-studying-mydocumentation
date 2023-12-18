<?php
/*
 * Sebelumnya saat kita melakukan query, kita bisanya menggunakan perulangan foreach untuk
   melakukan iterasi terhadap object PDOStatement
 * Permasalahannya, foreachh akan melakukan seluruh perulangan di hasil result, Bagaimana
   jika kita hanya ingin menambil data pertama saja misal? Maka kita harus membuat counter
   secara manual
 * Untungnya PDOStatement memiliki sebuah function bernama fetch(), fetch() digunakan untuk
   menarik/mengambil 1 data dari hasil query, ketika kita memanggil function fetch() lagi,
   maka otomatis akan menarik/mengambil data selanjutnya, jika dipanggail fetch() lagi, maka
   akan mengambil data ke-3 dan sterusnya
 * Jika function fetch mengembalikan nilai false, artinya sudah tidak ada data lagi yang bisa
   diambil dari hasil query
 * Jika ingin mengambil seluruh data sekaligus, kita bisa gunakan fetchAll()  
*/

require_once "database/Tes.php";

echo __DIR__ . PHP_EOL;

printDir();