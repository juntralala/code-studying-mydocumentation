<?php
/**
 * Saat kita membuat object DateTime, dia akan secara otomatis membuat waktu saat ini sesuai dengan timezone yang di setting
   pada konfigurasi date.timezone di file php.ini
 * Atau kita bisa menggunakan function setTimeZone untuk megubah timezone DateTime
*/

$dateTime = new DateTime();

var_dump($dateTime); // timezone defaultnya tergantung laptop

$dateTime->setTimezone(new DateTimeZone("Asia/Makassar"));

var_dump($dateTime);