<?php
/**
 * Sebelumnya saat membuat constant di Parent Class, kita bisa mengoverride di Child Class nya
 * Di PHP 8.1, sekarang kita bisa menambahkan kata kunci final di constant nya, sehingga
   tidak bisa di override di class childnya 
*/

class Foo {
    final const XX = "Foo";
} 

class Bar extends Foo {
    // const XX = "Foo"; // tidak bisa di override
} 