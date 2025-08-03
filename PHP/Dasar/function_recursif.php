<?php

function factorial(int $angka) {
    if ($angka === 1) return $angka;
    else return $angka * factorial($angka - 1);
}


var_dump( factorial(8) );
var_dump( factorial(4) );
var_dump( factorial(10000) );