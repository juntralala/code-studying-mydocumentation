<?php

/**
 * Salah satu fitur yang bahasa pemrograman lain yang sudah ada, namun bakhirdnya di tambahkan pada PHP 8.1 adalah enum
 * Enum adalah tipe data yang nilai nya terbatas
 * Sebelum ada enum biasanya kita manual membuat constant di PHP
 * Contohnya kita ingin membuat tipe data Gender, Level dan sejenisnya
 * Untuk  membuat enum kita bisa menggunakan keyword enum
*/

/** Menggunakan Enum
 * Untuk menggunakan enum, caranya sama seperti menggunakan static field
 * Dan enum memiliki static function case() yang mengembalikan array semua enum nya 
*/

enum Gender {
    case Male;
    case Female;
}

class Orang {
    public Gender $gender;
    public function __construct(Gender $gender) {
        $this->gender = $gender;
    }
}

$dawi = new Orang(Gender::Female);
$dawi->gender = Gender::Male;
var_dump($dawi);

$arrayEnumValue = Gender::cases();
var_dump($arrayEnumValue);


