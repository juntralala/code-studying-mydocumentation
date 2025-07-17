<?php
/**
 * Saat kita mengakses function, maka secara otomatis function akan di akses
 * Namun jika ternyata function tersebut tidak tersedia diobjectnya, maka PHP tidak akan secara otomatis
   menjadikan itu error
 * PHP akan melakukan CALLBACK ke magic function
 * Dengan demikian kita kita bisa membuat function yang dinamis dengan memanfaatkan magic function tersebut
 * Ada beberapa magic function yang bisa kita gunakan untuk function overloading
 */

 /** Magic function untuk function overloading
  * __call($name, $arguments):mixed Dieksekusi ketika memanggil function tidak tersedia
  * static __callStatic($name, $arguments):mixed Deksekusi ketika memanggil static function yang tidak tersedia
  */

class Zero {
  
  function __call($name, $arguments) {
    $join = join($arguments);
    echo "call Function with $name with arguments $join" . PHP_EOL;
  }

  static function __callStatic($name, $arguments) {
    $join = join($arguments);
    echo "call Function with $name with arguments $join" . PHP_EOL;
  }
  
}

$zero = new Zero();

$zero->tidakAda("Muhammad", "Junaidi");
Zero::tidakAda("Muhammad", "Junaidi");

