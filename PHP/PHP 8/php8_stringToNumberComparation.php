<?php
/**
 * Salah satu hal yang membingungkan di PHP adalah ketika kita melakukan perbandingan number dan string
 * Misal saat kita bandingan 0 == "eko", maka hasilnya true
 * Kenapa true? karena PHP akan melakukan type jugling dan mengubah "eko" menjadi 0, sehingga hasilnya true
 * Di PHP 8 khusus perbandingan String ke Number diubah, agar tidak membingungkan
 * https://wiki.php.net/rfc/string_to_number_comparison 
*/

/** Before dan After PHP 8 update
 * +===============+========+=======+
 * | Comparison    | Before | After |
 * +---------------+--------+-------+
 * |  0 == "0"     | true   | true  |
 * |  0 == "0.0"   | true   | true  |
 * |  0 == "foo"   | true   | false |
 * |  0 == ""      | true   | false |
 * | 42 == "  42"  | true   | true  |
 * | 42 == "foo42" | true   | false |
 * +---------------+--------+-------+
*/