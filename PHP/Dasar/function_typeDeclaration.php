<?php

function tambah(int $a, int $b) {
    echo ($a + $b) . PHP_EOL;
}

tambah( 2, 2);
tambah( 2, "2");       // auto terkonversi
tambah( true, true);
// tambah( [], []);     ini error