<?php
/**
 * stdClass adalah class kosong bawaan php
 * stdClass biasanya digunakan ketika kita mengkonversi dari tipedata lain menjadi tipe object
 * stdClass sangat berguna contoh ketika kita ingin mengkonversi tipedata array ke object secara otomatis 
*/

require_once __DIR__ . "/../constructor/Product.php";

$array = [
  "firstName" => "Muhammad",
  "lastName" => "Junaidi"
];

// array ke object
$object = (object)$array;

echo var_dump($object);
echo $object->firstName .PHP_EOL;
echo $object->lastName .PHP_EOL;

// object ke array
$arrayLagi = (array)$object;

echo var_dump($arrayLagi);
echo $arrayLagi["firstName"] .PHP_EOL;
echo $arrayLagi["lastName"] .PHP_EOL;

// object class kita ke array
$product = new Product("A001", "Bakso");

$array = (array)$product;
echo var_dump($array);
echo $array["id"] .PHP_EOL;
echo $array["name"] .PHP_EOL;

// Selain untuk mengkonversi Array ke Object stdClass di php juga bisa digunakan untuk membuat object
// yg tidak didefinisikan class nya
$orang = new stdClass();
$orang->name = "ujun";
$orang->address = "Kalimantas";
var_dump($orang);