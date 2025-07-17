<?php
/** Visibility / AccessModifier
 * Visibility/Access Modifier adalah pengatur dimana saja properties, function, constant dapat di akses 
 * Defaultnya class, function, dan constant yang kita buat adalah public, artinya bisa diakses dari mana saja
 * Defaultnya keyword var pada properties sifatnya public
*/

require_once "Company.php";

$asus = new Company("Asus", "Ujun");
echo "name    : {$asus->getName()}" .PHP_EOL;
echo "founder : {$asus->getFounder()}" .PHP_EOL;

$dumm = new CompanyDummy("UJUN", 'Muhammad Junaidi');
$dumm->info(); 