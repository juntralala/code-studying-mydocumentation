<?php
/**
 * Selain format DateTime menjadi string, di PHP juga bisa melakukan hal sebaliknya, yaitu parsing string menjadi DateTime
   sesuai dengan format yang kita mau
 * Untuk melakukan itu kita bisa menggunakan static function createFromFormat() dari class DateTime 
*/

$format = "d-m-Y H:i:s";
$stringDT = "20-05-2004 01:10:10";
$timezone = new DateTimeZone("Asia/Jakarta");

$dateTime = DateTime::createFromFormat($format, "Salah", $timezone); // parameter timezone cuman optional
// kalau format input nya salah maka akan mereturn false

if($dateTime) {
    var_dump($dateTime);
} else {
    echo 'Format input salah' . PHP_EOL;
}