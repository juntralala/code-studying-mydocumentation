<?php
/*
Callback function merupakan sebuah function yang diberikan sebagai argument
ke function lainnya. Callback function dapat dijalankan atau dipanggil
oleh function yang menerimanya sebagai argument. Dalam konteks pemrograman
event-driven, callback function digunakan untuk menangani event yang
terjadi setelah suatu aksi dilakukan. Misalnya, ketika tombol diklik pada
suatu aplikasi, maka event tersebut dapat mengeksekusi callback function
yang ditetapkan untuk menangani event tersebut. Callback function umumnya
digunakan untuk membuat program lebih modular dan fleksibel.
*/

function sayHello(string $name, $filter) {
    $finalName = call_user_func($filter, $name);

    echo "hello $finalName" . PHP_EOL;
}


sayHello("Ujun", "strtoupper");
sayHello("Ujun", "strtolower");
sayHello("Ujun", function($name) {
    return strtoupper($name);
});
sayHello("Ujun", fn($name) => strtoupper($name));