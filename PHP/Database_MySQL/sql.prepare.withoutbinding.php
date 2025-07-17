<?php
require_once "database/helper.php";

$username = "admin";
$password = "admin";

$connection = Helper\getConnection();
$sql = "SELECT *FROM admin WHERE username= ? AND password=?";
$result = $connection->prepare($sql);
$result->execute([$username, $password]); // pakai array tidak usah lagi melakukan binding 



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

$connection = null;
