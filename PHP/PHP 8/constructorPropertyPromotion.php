<?php

/**
 * Kadang kita sering sekali membuat property sekaligus mengisi property tersebut menggunakan constructor
 * Sekarang kita bisa otomatis langsung membuat property dengan via constructor
 * Fitur ini mirip sekali di bahasa pemrograman seperti Kotlin atau TypeScript
 * https://wiki.php.net/rfc/constructor_promotion
*/

class Orang {
    public function __construct(public string $name,
                                public int $age,
                                public string $address
    ){
    }
}


$ujun = new Orang("Ujun", 19, "Handil Rantau");