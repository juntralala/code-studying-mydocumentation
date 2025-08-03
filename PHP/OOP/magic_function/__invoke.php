<?php
/**
 * __invoke() merupakan function yanh di eksekusi ketika objectvyanh kita buat dianggap sebagai function
 * Misal kita membuat object Human, kemudian kita eksekusi human(), maka yang akan dieksekusi adalah function __invoke()
*/

require_once "Human.php";

$amat = new Human("Amat", "Corn", 92);

echo $amat("makan", "Sakulah", "guring", "bahira") .PHP_EOL;