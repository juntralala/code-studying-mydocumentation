<?php

/**
 * Sebelumnya kita sudah tau, bahwa class bisa menggunakan trait lebih dari satu
 * Lantas bagaimana dengan trait yang menggunakan trait lain ?
 * Trait bisa menggunakan trait lain, mirip seperti interface yang implements interface lain
 * Untuk menggunakn trait lain dari trait, sama seperti penggunakan trait di class
*/

require_once "data/All.php";

class Person {
  use All;
}

$orang = new Person();
$orang->sayHello("Ujun1");
$orang->sayGoodbye("Ozon");
echo $orang->name .PHP_EOL;