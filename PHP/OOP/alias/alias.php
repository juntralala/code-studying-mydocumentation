<?php
/**
 * Saat kita menggunakan namespace artinya tidak perlu lagi menggunakan nama namespace di awal class ketika kita ingin menggunakan class terswbut
 * Namun bagaimana jika ternyata ada nama class yang sama?
 * Untungnya php memiliki fitur yang namanya class 
 * Alias adalah kemampuan membuat nama lain dari class, function atau constant yang ada
 * Kita bisa menggunakan as sesudah use untuk membuat alias
*/

include_once "../namespace/Conflict.php";
include "../namespace/Helper.php";

use Data\One\Conflict as Confl1;
use Data\Two\Conflict as Confl2;
use function Helper\help as tolong;
use const Helper\APPLICATION as APP;

echo var_dump(new Confl1());
echo var_dump(new Confl2()); 
tolong();
echo APP .PHP_EOL;
