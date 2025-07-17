<?php
/** use keyword
 * Sebelumnya kita sudah tahu kalau mau menggunakan class, function, dan const di namespace kita perlu penyebutkan nama namespacenya
 * Jika terlalu banyak menggunakan class, function, atau const yang sama, maka akan terlalu banyak duplikasi denhab menyebut namespace yanh sama berkali-kali
 * Hal ini bisa kita hindari dengan mengimport class, function atau const tersebut dengan keyword use
 */
 
include "../namespace/Conflict.php"; 
include "../namespace/Helper.php"; 
/* <=====================================================>*/

use Data\One\Conflict;
use function Helper\help;
use const Helper\APPLICATION;

$confl = new Conflict();

echo var_dump($confl);
help();
echo APPLICATION .PHP_EOL;