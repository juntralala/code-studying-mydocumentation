<?php
/**
 * Di PHP 8 diperkenalkan dengan Union Types, dimana kita bisa membuat properties atau parameter yang bisa digunakan
   untuk beberapa tipe data
 * Di PHP 8.1,terdapa fitur intersection types, dimana kita bisa membuat properties atau parameter yang wajib sesuai dengan
   beberapa tipe data (harus turunan dari bebrapa tipeData)
 * Ini cocok ketika kita ingin menentukan misal parameter harus merupakan tipe data turunan beberapa interface misalnya
 * Jika union types menggunakan karaketer |, sedangkan intersection types menggunakan karakter &  
 * Sama seperti Union Types, untuk Intersection Types juga bisa digunakan untuk beberapa tipe data, tanpa ada batasan
*/

interface HashBrand {
    function getBrand():string;
}

interface HashName {
    function getName():string;
}

class Car implements HashBrand, HashName{
    public function __construct(public string $brand,
                                public string $name) {
    }

    function getBrand():string {
        return $this->brand;
    }

    function getName():string {
        return $this->name;
    }
}

function printBrandAndName(HashBrand & HashName $value) {
    echo $value->getBrand() . " - " . $value->getName() . PHP_EOL;
}

// ================================================================
printBrandAndName(new Car("Toyota", "Avanza"));
printBrandAndName(new Car("Honda", "Mobilio"));