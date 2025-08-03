<?php
/**
 * PDOStatement adalah sebuah class turunan dari IteratorAgregate
 * Seperti yang sudah kita bahas di materi PHP OOP, bahwa turunan IteratorAgregate secara 
   otomatis bisa menggunakan perulangan foreach
 * Oleh karena itu untuk melakukan iterasi hasil query, kita bisa melakukan perulangan 
   foreach untuk tiap baris utuk tiap baris SQL row nya
*/

use LDAP\Result;

require_once "database/helper.php";

$connection = Helper\getConnection();
$sql = "SELECT id, name, email FROM costumers";
$result = $connection->query($sql);

foreach($result as $row) {
    $id = $row['id'];
    $name = $row['name'];
    $email = $row['email'];

    echo "Id\t: $id" . PHP_EOL;
    echo "Name\t: $name" . PHP_EOL;
    echo "email\t: $email" . PHP_EOL;
}

$connection = null;