<?php
/*
arrow function pada php mirip seperti anonymous function dan perbedaan
pada keduanya adalah arrow function bisa menggunaan variable yang ada
diluarnya 
*/

$nama = "Muammad Junaidi";

$sapa = fn() => "Hai $nama";

echo $sapa() . PHP_EOL;