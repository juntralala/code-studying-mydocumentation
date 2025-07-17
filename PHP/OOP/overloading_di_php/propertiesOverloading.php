<?php

/**
 * Saat kita mengakses properties, maka secara otomatis prperties akan di akses
 * Namun jika properties tersebut tidak ada di object nya, maka php tidak akan secara otomatis
   menjakan itu error
 * PHP akan melakukan CALL BACK ke magic function
 * Dengan demikian kita bisa membuat proprties secara dinamis menggnakan function tersebut
 * Ada beberapa function yang bisa kita gunakan untuk properties overloading 
 */

 /** Magic function untuk propertie overloading
  *  __set($name, $value):void  Dieksekusi ketika mengubah properties yang tidak tersedia
  *  __get($name):mixed         Dieksukusi ketika mengakses properties yang tidak tersedia 
  *  __isset($name):bool        Dieksukusi ketika mengecek isset() dan empty() properties yang tidak tersedia 
  *  __unset($name):void        Dieksukusi ketika menggunakan unset() properties yang tidak tersedia 
  */

class Zero {
    private array $properties = [];

    public function __get($name):mixed {
        return $this->properties[$name];
    }

    public function __set($name, $value):void {
        $this->properties[$name] = $value;
    }

    public function __isset($name):bool {
        return isset($this->properies[$name]);
    } 

    public function __unset($name):void {
        unset($this->properties[$name]);
    }

}

$zero = new Zero();

echo var_dump($zero->name) .PHP_EOL;
$zero->name = "UJUN";
echo var_dump($zero->name) .PHP_EOL;

echo var_dump(isset($zero->name)) . PHP_EOL;
unset($zero->name);

    
