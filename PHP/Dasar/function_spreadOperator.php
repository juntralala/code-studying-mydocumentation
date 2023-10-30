<?php

function tambah(int ...$numbers) {
    $total = 0;
    foreach ($numbers as $number) {
        $total += $number;
    }
    echo $total . PHP_EOL;
}

$iniArray = [ 3, 7, 5, 5];
tambah(...$iniArray);


