<?php
/**
 * Di PHP 8.1 sekarang terdapat kata kunci readonly, yang bisa digunakan di property
 * Dengan menggunakan kata kunci readonly, sekaraang kita bisa membuat sebuah propery hanya bisa dibaca dan tidak bisa diubah lagi
 * Readonly properties yang dituntakan datanya sekali, dan tidak bisa diubah lagi 
*/

// class Category {
//     public readonly string $id;
//     public readonly string $name;
//     function __construct(string $id, string $name) {
//         $this->id = $id;
//         $this->name = $name;
//     }
// }
class Category {
    function __construct(public readonly string $id, 
                         public readonly string $name) {
    }
}

$category = new Category("123", "Bakso");

var_dump($category);