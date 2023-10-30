<?php
/*
secara default, anonymous function tidak bisa mengakses variable yang
ada diluar

jika kita ingin menggunkan variable yang ada diluar anonymous function,
kita harus menuliskan secara exlplisit kata kunci use diikuti dengan variable
yang ingin digunakan
*/
$namaDepan = "Muhammad";
$namaBelakang = "Junaidi";
$sapa = function() use ($namaDepan, $namaBelakang) {
    echo "hai $namaDepan $namaBelakang" . PHP_EOL;
};

$sapa();

$namaBelakang = "Barizi";

$sapa();