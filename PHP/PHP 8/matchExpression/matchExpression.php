<?php
/**
 * PHP 8 menambahkan struktur control baru bernama match expression
 * Match expression adalah struktur kontrol yang mirip dengan switch case, namun lebih baik
 * https://wiki.php.net/rfc/match_expression_v2
 * https://wiki.php.net/manual/en/control-structures.match.php
*/

// contoh switch statement
$value = "A";
$hasil = "";
switch($value) {
    case "A":
    case "B":
    case "C":
        $hasil = "Anda lulus";
        break;
    case "D":
        $hasil = "Anda tidak lulus";
    case "E":
        $hasil = "Mungkin kamu salah jurusan";
    default:
        $hasil = "Nilai INVALID";
}
echo $hasil, PHP_EOL;

// contoh match expression
$value = "A";
$hasil = match($value) {
    "A","B","C"=>"Anda lulus",
    "D" =>"Anda tidak lulus",
    "E" =>"Mungkin kamu salah jurusan",
    default =>"Nilai INVALID"
};

echo $hasil, PHP_EOL;
