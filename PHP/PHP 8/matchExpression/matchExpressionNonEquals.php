<?php
/**
 * berbeda dengan switch statement, Selain equals check, di match expression, kita bisa melakukan pengecekan kondisi lainnya 
 * Misalnya pengecekkan menggunakan operator perbandingan, bahkan pengecekkan kondisi berdasarkan boolean expression yang dihasilkan dari sebuah expression
*/

$nilai = "78";

$hasil = match(true){
    $nilai > 80 && $nilai <= 100 => "A",
    $nilai > 70 && $nilai <= 80 => "B",
    $nilai > 60 && $nilai <= 70 => "C",
    $nilai > 50 && $nilai <= 60 => "D",
    $nilai >= 0 && $nilai <= 60 => "E",
    default => "Nilai Invalid"
};

echo $hasil .PHP_EOL;

// ================================
$nama = "Mr. ujun";

$hasil = match(true) {
    str_contains($nama, "Mr.") => "Hello sir",
    str_contains($nama, "Mrs.") => "Hello mam",
    default => "Hello"
};

echo $hasil .PHP_EOL;