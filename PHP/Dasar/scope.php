<?php
/*
variable global di PHP tidak bisa di akses didalam function

variable global bisa di akses tetapi harus menggunakan keyword global
*/

$nama = "ujun";

// function sapa() {
//     echo "Hai $nama";
// }                              // disini error

function sapa2() {
    global $nama;
    echo "Hai $nama" . PHP_EOL;
    echo "Hai {$GLOBALS['nama']}" . PHP_EOL;
}

sapa2();