<?php
/** Atribute Class
 * Atribute class adalah sama dengan class biasa, jadi kita bisa menambahkan property, function/method dan constructor jika kita mau
 * Ini cocok ketika kita butuh menambahkan informasi 
*/

#[Attribute(Attribute::TARGET_PROPERTY | Attribute::TARGET_PARAMETER)]
class Length{
    var int $min;
    var int $max;

    public function __construct(int $min, int $max) {
        $this->min = $min;
        $this->max = $max;
    } 
}

// penggunaan nya ada di attributes.php