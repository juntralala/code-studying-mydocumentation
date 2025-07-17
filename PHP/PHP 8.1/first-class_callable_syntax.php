<?php
/**
 * Di PHP 8.1, sekarang kita bisa membuat sebuah references ke function secara mudah hanya dengan menggunakan tanda ... (titik 3 kali) 
*/

class Person {
    public function __construct(public string $name) {}
    public function sayHello(string $name):void {
        echo "hello $name, my name is $this->name" . PHP_EOL;
    }
}

$budi = new Person("Budi");
$references = $budi->sayHello(...);
$references("Udin");

$print = var_dump(...);

