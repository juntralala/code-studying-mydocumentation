<?php
/** Binding Parameter Dengan Index
 * Selain menggunakan katakunci :namaparameter
 * Untuk melakukan binding parameter, kita juga bisa menggunakan index(angka)
 * Kita cukup ganti :namaparameter dengan ? (tanda tanya)
 * Lalu gunakan nomor index, saat melakukan bindingParam(index, value) 
 */

 require_once "database/helper.php";

$username = "admin";
$password = "admin";

$connection = Helper\getConnection();
$sql = "SELECT *FROM admin WHERE username= ? AND password=?";
$result = $connection->prepare($sql);
$result->bindParam(1, $username); // binding menggunakan index
$result->bindParam(2, $password);
$result->execute();
 


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


