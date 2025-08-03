<?php
// ini lanjutan dari sql.solusi_sql_injection.php

/** Prepare Statement
 * Cara yang lebih aman untuk membuat SQL dengan input parameter dari user sebenarnya
   menggunakan function prepare()
 * function prepare akan menghasilkan object PDOStatement, dimana kita bisa melakukan
   binding parameter ke perintah SQL yang kita buat
 * Ini lebih aman dibandingkan menggunakan function quote() secara manual, karena rawan lupa
 * Namun jika menggunakan function prepare(), pembuatan SQL string nya akan sedikit berbeda.
 * Ketika kita ingin menambahkan parameter, kita harusmenggunakan :nama_parameter 
*/

/** Binding Parameter
 * Setelah menentukan dimana kira-kira parameter akan digunakan di kode SQL
 * Kita wajib melakukan binding parameter dengan input user
 * Secara otomatis, semua input dari user akan di quote() oleh prepareStatement, jadi kita 
   tidak perlu lagi mellakukannay secara manual
 * Hal ini membuat prepareStatement lebih aman di bandingkan manual menggunakan quote()
*/
require_once __DIR__ . "/database/helper.php";

$username = "admin'; #";
$password = "salah password";

$connection = Helper\getConnection();
$sql = <<<SQL
SELECT *FROM admin
WHERE
    username= :username AND
    password= :password
SQL;
$result = $connection->prepare($sql);
$result->bindParam("username",$username); // binding pakai nama dari parameter
$result->bindParam("password",$password);
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