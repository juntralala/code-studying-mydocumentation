<?php
/*
variable parsing bisa digunakan pada 
1. string double quote("")
2. heredoc
*/

$nama = "UJUN";
$umur = 18;


$bio = <<<HD
Nama : $nama
Umur : $umur
HD;

echo "nama : $nama" . PHP_EOL;
echo "umur : $umur" . PHP_EOL;
echo $bio;
