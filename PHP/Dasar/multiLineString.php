<?php
/*
mltu line string ada 2 :
1. heredoc
2. nowdoc

perbedaan nowdoc adalah tidak bisa menggunakan parsing
*/

// heredoc
echo <<<MS
nama : Muhammad Junaidi
umur : 18
kelas: 3 Ulya
MS;

echo "\n\n";

// nowdoc
echo <<<'MS2'
belajar php
dari tutorial channel Programer Zaman Now
hari    : Kamis
tanggal : 04/05/2023
MS2;