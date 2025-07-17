<?php
/**
 * Di PHP 7, terdapat tipe data mixed, tipe data ini digubnakn ketika sebuah argument atau return function yang mengembalikan
   tipe data yang bisa berbeda-beda
 * Karena tidak bisa menyebutkan tipe data yang berbeda-beda di PHP 7, maka biasanya ditambakan lah tipe data baru bernama mixed
 * Di PHP 8, tipeData mixed diperbarui, karena di PHP sudah ada Union Type, jadi sekarang tipe data mixed adalah singkatan dari
   tipe data : array|bool|callable|int|float|null|object|resource|string
 * https://wiki.php.net/rfc/mixed_type_v2
*/

function fungsi(mixed $data):mixed {
    if(is_array($data)) {
        return [];
    } elseif (is_int($data)) {
        return 0;
    } elseif (is_string($data)) {
        return "";
    } else {
        return null;
    }
}

var_dump(fungsi([]));
var_dump(fungsi(12));
var_dump(fungsi(new StdClass()));
var_dump(fungsi(""));