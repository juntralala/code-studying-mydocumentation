<?php

function tambah(int $a, int $b): int {
    return $a + $b;
}

function ketLulus(int $nilai): string {
    if ($nilai >= 70) {
        return "lulus";
    } else if ($nilai < 70 && $nilai != 0 ) {
        return "tidak lulus";
    } else {
        return 404;  // <- akan dikonversi menjadi string
    }
};

$hasil = tambah( 3, 3);
var_dump($hasil);

var_dump( ketLulus(0));