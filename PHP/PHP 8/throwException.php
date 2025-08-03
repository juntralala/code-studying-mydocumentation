<?php
/**
 * sebelumnya, throw adalah statement
 * Terkadang, gal ini menyebabkan kita kesulitan menggunakan throw di beberapa tempat yang membutuhkan expression, ternary operator misalnya
 * Di PHP 8, kini throw adalah expression, artinya dia adalah memilili nilai, dan sekarang kita bisa menggunakannya di tempat-tempat yang memeang membutuhkan expression
   seperti ternary operator
 *  https://wiki.php.net/rfc/throw_expression
*/

// contoh bukan expression
function sapa(?string $nama) {
    if($nama == null) {
        throw new Exception("tidak boleh null");
    }
    echo "Hai $nama" . PHP_EOL;
}

// contoh yang expression
function sapaExpression(?string $nama) {
    $result = $nama!=null ? "Hai $nama" : throw new Exception("Tidak Boleh NUll");
    echo $result . PHP_EOL;
}

sapaExpression("ujun");
sapaExpression("Junaidi");
// sapaExpression(null);