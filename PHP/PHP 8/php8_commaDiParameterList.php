<?php
/**
 * Ini adalah salah satu fitur yang sedergana namun bermanfaat
 * Di PHP 8, sekarang kita bisa menambahkan char koma di akhir parameter list, seperti ketika membuat function, array dll
 * https://wiki.php.net/rfc/trailing_comma_in_parameter_list 
 * https://wiki.php.net/rfc/trailing_comma_in_closure_use_list 
*/

function test(
    string $param1,
    string $param2,
    string $param3,
) {}

function jumlah(int... $angka) {}

jumlah(
    1,
    1,
    1,
    1,
);

$name = [
    "first" => "Muhammad",
    "last" => "Junaidi",
];