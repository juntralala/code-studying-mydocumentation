<?php
/**
 * __string() adalah salah satu magic function yang digunakan sebagai representasi string sebuah object
 * misal kita ingin membuat string dari object kita, kita bisa gunakan __toString()
 * jadi saat kita mengkonversi object menjadi string, sebenarnya function __toString() ini yang dipanggil
*/

require_once "Human.php";

$udin = new Human("udin", "rice", 118);

echo $udin .PHP_EOL;

$udinStr = (string) $udin;

echo $udinStr .PHP_EOL;