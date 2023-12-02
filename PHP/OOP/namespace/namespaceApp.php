<?php

/**
 * Saat membuat aplikasi, sudah dipastikan kita akan membuat banyak class
 * Jika class sudah terlalu banyak, kadang akan menyulotkan kita untuk mencari atau mengklasifikasikan class jenis-jenis
 * PHP memiliki fitur namespace, dimana kita bisa meletakkan class-class didalam namespace
 * Namespace bisa nested, jika kita ingin mengakses class didalam namespace, kita perlu menyebutkan nama namespace nya
 * Bagusnya namespace, ketika kita memiliki 2 class dengan nama class yang sama tidak akan menyebabkan error di PHP
*/

require_once "Conflict.php";
require_once "Conflict3.php";

$confl1 = new \Data\One\Conflict(); // backSlash di awal cuman optional
$confl2 = new Data\Two\Conflict(); 
$confl3 = new Data\Three\Conflict();
echo "Program Success : True".PHP_EOL;

