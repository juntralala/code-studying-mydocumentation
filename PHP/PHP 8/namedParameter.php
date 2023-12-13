<?php
/**
 * Biasanya saat kita memanggil function, maka kita harus memasukkan argument atau parameter sesuai dengan posisinya
 * Dengan kemampuan named argument,kita bisa memeasukkan argument atau parameter tanpa harus mengikuti posisi nya
 * Namun penggunaan named argument harus disebutkan nama arguement/parameter nya
 * Named argument juga menjadikan program mudah dibaca ketika memanggil function yangmemiliki argument yang sangat banyak
 * https://wiki.php.net/rfc/named_params
*/

function sayHello(string $first,string $second = "",string $last) {
    echo "Hello $first $second $last" . PHP_EOL;
} 

sayHello("Ujun", "Muhammad", "Junaidi");
sayHello("Ujun",second: "Muhammad",last: "Jzunaidi");
sayHello(first: "Ujun",second: "Muhammad",last: "Junaidi");

sayHello(first: "Muhammad",last: "Junaidi");