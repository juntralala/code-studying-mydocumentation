<?php

/**
 * Saat kita mengoverride function dari parent class, biasanya di child kita akan membuat function yang sama dengan function
   yang ada di parent
 * Covariance memungkinkan kita mengoverride return function yang di parent dengan return value yang lebih spesifik
 */

require_once "Animal.php";

$dogShelter = new DogShelter();
$catShelter = new CatShelter();

echo var_dump($dogShelter);
echo var_dump($catShelter);


