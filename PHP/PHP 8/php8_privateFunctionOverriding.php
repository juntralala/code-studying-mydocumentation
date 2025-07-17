<?php
/**
 * Di PHP 7, saat kita membuat function, tapi ternyata di parentnya terdapat funciton dengan nama yang sama, walaupun private,
   hal itu akan dianggap overriding
 * Padahal sudah jelas private function tidak boleh/bisa diakses oleh turunannya
 * Di PHP 8,sekarang private function tidak akan ada lagi hubungannya lagi dengan child class nya, sehingga kita bebas membuat 
   function dengan nama yang sama walaupun diparent ada function private dengan nama yang sama
 * https://wiki.php.net/rfc/inheritance_private_methods 
*/

class Manager {
    private function test():void {}
}

class VicePresident extends Manager{
    function test(string $data):string {
        return "";
    }
}
