<?php

/**
 * Biasanya dalam bahasa pemrograman sudah disediakan cara untuk manipulasi data & waktu, termasuk PHP
 * Di PHP, kita bisa mengunakan class DateTime untuk manipulasi data waktu
 * Ada banyak sekali function di class DateTime yang bisa kita gunakan untuk manipulasi data waktu
*/

/** DateTime Function 
 * setTime($hour, $minute, $second) Mengubah Waktu DateTime
 * setDate($year, $month, $day) Mengubah Tanggal DateTime
 * setDate($unixTimestamp) Mengubah unix Timestamp DateTime
*/

$dateTime = new DateTime();

var_dump($dateTime);

$dateTime->setDate(2004, 05, 20);
$dateTime->setTime(01, 10, 10, 0);

var_dump($dateTime);