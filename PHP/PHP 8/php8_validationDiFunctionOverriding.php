<?php
/**
 * Sebelumnya kita tahu bahwa mengoverride dengan mengubah signature function hanya akan menimbulkan warning bukan error
 * Di PHP 8, hal tersebut akan menimbulkan error
 * Sehingga kita tidak bisa lagi mengubah signature dari function yang kita override, seperti mengubah parameter atau return value
 * https://wiki.php.net/rfc/lsd_errors 
*/

    class ParentClass {
        function fungsi(int $data):int {
            return 0;
        }
    }

    class ChildClass extends ParentClass{
        // ini error karna peng-overridingannya tidak sesuai dengan parentnya
        // function fungsi(string $data):string {
        //     return "";
        // }
    }

