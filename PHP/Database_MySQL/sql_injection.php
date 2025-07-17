<?php
/**
 * SQL Injection adalah sebuah teknik yang menyalah gunakan sebuah celah keamanan yang
   terjadi dalam basis data sebuah applikasi
 * Biasanya, SQL Injection dikirim dengan cara mengirip input user dengan perintah yang
   salah sehingga menyebabkan hasil SQL yang kita buat tidak valid
 * SQL Injection sangat berbahaya, jika sampai kita salah membuat SQL, bisa jadi data kita 
   tidak aman
*/

// Solusinya ada di sql.quot.php

require_once "database/helper.php";

$connection = Helper\getConnection(); 

// contoh, misalnya ada input user
$username = "admin' ; #";      // <- injectionnya di sini
$password = "sadinya salah";  // sadi yang benar 'admin'

$sql = "SELECT username, password FROM admin WHERE username='$username' AND password='$password'";

$result = $connection->query($sql);
$success = false;
$find_user = null;
foreach($result as $row) {
    $success = true;
    $find_user = $row['username'];
}
if($success) {
    echo "Berhasil Log in sebagai : {$row['username']}" . PHP_EOL;
} else {
    echo "Gagal Log in" . PHP_EOL;
}

echo PHP_EOL;
var_dump($result);
$connection = null;

