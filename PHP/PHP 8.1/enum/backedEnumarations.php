<?php
/**
 * Kadang saat kita membuat enum, kita ingin membuat enum yang merpresentasikan data lainnya, misal data string ata integer misalnya
 * PHP enum mendukung hal tersebut, caranya kita bisa menambahkan titik dua, lalu diikuti degan tipe datanya
 * Misal enum Gender:string, artinya enum Gender ini bisa merepresentasikan tipe data string 
*/

/**
 * Diantara keuntungan menggunakan backed enumarations adalah, kita bisa meng-konversi tipe enumnya ke tipe data backed nya 
 * Kita bisa static function from atau tryFrom() untuk konversi ke Enum
 * Atau menggunakan filed value untuk menfapatkan tipe data backed nya
*/

enum Gender:string {
    case MALE = "Mr";
    case FEMALE = "Mrs";
}

class Orang {
    public function __construct(
        public string $nama,
        public Gender $gender) {
    }
}

function sapa(Orang $orang){
    if($orang->gender == null) {
        echo "Hallo $orang->nama" . PHP_EOL;
    } else {
        echo "Hallo {$orang->gender->value}. $orang->nama" .PHP_EOL;
    }
}


$dayat = new Orang("UJUN", Gender::MALE);

var_dump($dayat); 

sapa($dayat);