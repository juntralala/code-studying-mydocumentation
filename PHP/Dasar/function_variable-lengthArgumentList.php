<?php

function tambah(int ...$numbers) {
    $total = 0;
    foreach ($numbers as $number) {
        $total += $number;
    }

    echo $total;
}

tambah( 4, 6, 8, 2);