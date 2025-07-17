<?php
/**
 * Di PHP 8, sekarang diperkenalkan interface baru bernama Stringable
 * Jika kita melakukan  override magic function __toString(), maka secara otomatis function kita akan impplementasi interdace Stringable
 * Kita tidak perlu melakukannya secara manual, karna ini sudah dilakukan secara otomatis di PHP 8
 * https://wiki.php.net/rfc/stringable 
*/

class Teman {
    function __construct(public string $nama) {}
    function __toString(){
        return $this->nama;
    }
}

class Orang {
    function __construct(public string $nama) {}
}

function sapa(Stringable $stringable) {
    echo "halo $stringable->nama" .PHP_EOL;
}


sapa(new Teman("Ilham"));
// sapa(new Orang("Zilani")); // error karna Orang tidak mengoverride __toString();