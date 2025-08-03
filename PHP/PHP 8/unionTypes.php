<?php
/**
 * PHP adalah bahasa pmerograman yang dynamic
 * Kita tahu saat membuat variable, parameter, argument , return value, sebenarnya di PHP kita tidak wajib menyebutkan tipeData nya, PHP bisa berubah-ubah tipe datanya
 * Saat kita menambahkan tipe data, maka secara otomatis PHP akan memastikan tipe data tersebut harus sesuai dengan tipe data yang telah didefinisikan
 * Di PHP 8, ada fitur Union Types,dimana kita bisa menambahkan lebih dari 1 tipe data ke property, argument, parameter, atau return value
 * Penggunaan Union Types bisa menggunakan tanda | diikuti dengan tipde data selanjutnya
 * https://wiki.php.net/rfc/union_types_v2    
*/

class Contoh{
    public function __construct(
        public string | int | bool | array $data
    ){}

    public function __toString() {
        return (string) $this->data;
    }
}

$contoh = new Contoh("ini adalah string");
echo $contoh;

$contoh = new Contoh(6);
echo $contoh;

$contoh = new Contoh(true);
echo $contoh;

$contoh->data = "ujun"; 
echo $contoh;