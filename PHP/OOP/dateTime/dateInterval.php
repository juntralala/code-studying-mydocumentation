<?php

/**
 * Kadang kita hanya ingin memanipulasi waku & tanggal sebgian saja, misal hanya menambah 1 tahun, atau mengurai beberapa hari
 *  hal ini bisa dilakukan menggunakan dengan function add() milik DateTime 
 * Namun function tersebut menerima parameter berupa DateInterval
 * Saat menggunakan DateInterval duration, kita perlu menentukan berapa banyak kita menambahkan interval
 * Kita bisa lihat detail nya disini : http;//www.php.net/manual/en/dateinterval.construct.php
 * Untuk membuat duration, harus diawali dengan karakter P yang artina period
*/ 

include "dateTime.php";

// menambah waktu
$dateTime->add(new DateInterval("P1Y")); 
var_dump($dateTime);

// mengurangi waktu 
$minusOneYear = new DateInterval('P1Y');
$minusOneYear->invert = true;
$dateTime->add($minusOneYear);
var_dump($dateTime);

