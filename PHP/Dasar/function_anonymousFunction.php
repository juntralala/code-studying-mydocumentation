<?php

$sapa = function(string $nama) {
    echo "hai $nama" . PHP_EOL;
};

$sapa("Ujun");

// anonymous function sebagai argument
function selamatTinggal(string $nama, $filter) {
    $namaAkhir = $filter($nama);
    echo "Selamat tinggal $namaAkhir" . PHP_EOL;
}

selamatTinggal("muhammad Junaidi", function($text) {
    return strtoupper($text);
});


