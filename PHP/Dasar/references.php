<?php

$nama = "UJUN";
$otherNama = &$nama;

echo "nama\t\t: $nama" . PHP_EOL;
echo "otherNama\t: $otherNama" . PHP_EOL;

$otherNama = "AJID"; 

echo "nama\t\t: $nama" . PHP_EOL;
echo "otherNama\t: $otherNama" . PHP_EOL;
