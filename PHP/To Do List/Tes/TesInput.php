<?php

require_once __DIR__ . "/../Helper/Input.php";

$nama = input("Masukan Nama Anda");
$umur = input("Masukkan Umur mu");

echo "Nama mu : $nama" . PHP_EOL;
echo "Umur mu : $umur" . PHP_EOL;