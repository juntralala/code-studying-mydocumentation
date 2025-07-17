<?php
namespace UjunAlRantaui\Belajar\PHP\MVC\Controller;

class ProductController {

    public function categories(string $productId, string $categoryId){
        echo "PRODUCT $productId, CATEGORY $categoryId";
    }

}