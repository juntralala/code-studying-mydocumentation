<?php
/**
 * Sebelumnya kita sering melakukan debug menggunakan function var_dump()
 * function var_dump() sebernarnya memanggil function __debugInfo()
 * jika kita ingin mengubah isi dari debug info, kita bisa mengubah function __debugInfo()
*/

require_once "Human.php";

$kozuki = new Human("Kozuki", "Sawit", 178);

echo var_dump($kozuki);