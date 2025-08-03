<?php
/**
 * Di PHP 8, sekarang terdapat validasi ketika mengimplementasikan abstract function di class dari trait
 * di PHP 7, saat kita mengubah hal seperti parameter dan return value nya, hal itu tidak akan menjadi masalah
 * Namun di PHP 8, jika kita mengubah implementasinya dari abstract function nya, maka akan otomatis error
 * https://wiki.php.net/rfc/abstract_trait_method_validation 
*/

trait Contoh{
    abstract function contoh(int $data):int ;
}

class ContohImpl{
    use Contoh;

    // implementasi ini error
    function contoh(string $data):string {
        return "";
    }
}