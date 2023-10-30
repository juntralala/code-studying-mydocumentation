<?php
/*
dot(.) operator adalah operator yang digunakan untuk mengabungkan string dengan
tipe data lain(number, boolean dll)

sebenarnya kita bisa menggunakan operator + untuk mengabung string. Namun, jika
kita mencoba menggabungkan string dengan tipedata number, maka akan terjadi error
oleh karena itu lebih disarankan untunk menggunakan operator dot(.) untuk menggabungkan
string
*/

$nama = "Muhammad Junaidi";
$umur = 18;
echo "nama : " . $nama . PHP_EOL;
echo "nama : " . $umur . PHP_EOL;
