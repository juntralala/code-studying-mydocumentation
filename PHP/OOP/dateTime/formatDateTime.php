<?php
/**
 * Kadang kita ingin membuat representasi string dari DateTime yang sudah kita buat
 * Hal ini bisa kita lakukan menggunakan function format()
 * Function format menerima agument berupa string, ini bisa kita gunakan untuk manipulasi cara kita menampilkan string format waktu
 * Untuk detailnya bisa kita liat di halaman dokumentasi resminya :
 * https://www.php.net/manual/en/datetime.format.php        
*/

$dateTime = new DateTime();

$string = $dateTime->format("d-m-Y H:i:s");

echo "Waktu saat ini : $string" .PHP_EOL;

$string = $dateTime->format("D-M-Y h:i:s");
echo "Waktu saat ini : $string" .PHP_EOL;





