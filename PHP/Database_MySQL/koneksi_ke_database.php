<?php
/**
 * Sebelum kita melakukan manipulasi data ke database dengan mengirimkan perintah SQL, hal yang perlu
   kita lakukan terlebih dahulu adalah membuat koneksi ke database
 * Untuk membuat koneksi kedatabase MySQL menggunakan PDO sangatlah mudah, kita hanya butuh
   membuat object PDO
 * Dan saat kira membuat koneksi ke MySQL menggunakan PDO adalah kita harus tentukan host, 
   port, database_name, username, dan passwordnya 
*/

$host = "localhost";
$port = 3306;
$database = "belajar_php_database";
$username = "ujun";
$password = "";
try {
  $connection = new PDO("mysql:host=$host:$port;dbname=$database", $username, $password);
  echo "Berhasil terkoneksi ke database MySQL" . PHP_EOL;
} catch (PDOException $e) {
  echo "PHP gagal terkoneksi ke Database : " . $e->getMessage() . PHP_EOL;
}
