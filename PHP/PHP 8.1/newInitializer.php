<?php
/**
 * Sekarang kita bisa menggunakan default value di parameter menggunakan new initializer 
 * Sebelumnya kita bisa menggunakan kata kunci new ketika membuat default value
*/

class Category {
    function __construct(public string $id, 
                         public string $name) {
    }
}

class Product {
    public function __construct(public string $name = "Bakso",
                                public Category $category = new Category("A101", "Makanan")) { // sebelumnya ini tidak bisa diakukan
    }
}


$product = new Product();

var_dump($product);