<?php
/** Trait
 * Selain class dan interface pada PHP terdapat fitur lain bernama Trait
 * Trait mirip seperti abstract class, kita bisa menambahkan konkrit function dan abstract function
 * Bedanya, Trait bisa ditamkan ke class lebih dari satu
 * Trait mirip seperti extention dimana kita bisa menambkan konkrit function kedalam class dengan Trait
 * Secara sederhana trait adalah digunakan untuk menyimpan function-function yang bisa digunakan ulang dibeberapa class
 * Untuk menggunakan trait kita bisa gunakan keyword use
*/

/** Trait properties
 * Berbeda dengan interface, di trait kota bisa menambahkan properties 
 * Dengan menambahkan properties otomatis class akan memiliki properties trait tersebut
*/

/** Trait abstract function
 * Selain konkrit function, kita juga bisa menambahkan abstract function
 * Jika terdapat abstract function di trait, maka secara otomatis harus di override pada class yang menggunakan trait tersebut
*/

/** Trait Overriding
 * Jika class memiliki parent yang mempunyai function yang sama dengan function di trait, maka secara otomatis trait akan mengoverride function tersebut
 * Dan jika kita membuat pada class function yamg sama dengan di trait, maka akan mengoverride function di trait
 * Ururtanya : ParentClass =overrideby> Trait =overrideby> Class
*/

/** Trait Visibility override
 * Selain dapat mengoverride function di class, kita juga bisa mengoveride visibility function pada Trait
 * Dan untuk melakukan ini kita tidak perlu membuat function di class, kita bisa lakukan secara sederhana ketika meng use Trait nya
*/
 
require_once "data/Person.php";
 
$orang = new Person();

// $orang->sayHello("Ujun"); // error karna di set ke private
$orang->sayGoodbye("Lahab");
echo $orang->name .PHP_EOL;
$orang->run();

$orang->sapa("Dawi");