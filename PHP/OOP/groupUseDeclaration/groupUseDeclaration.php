<?php
/**
 * Kadang kita perlu melakukan banyak use pada namespace yang sama
 * PHP memiliki fitur grup use, dimana kita bisa melakukan import beberapa class, function dan constant dalam sekali perintah use
 * untuk melakukan itu kita bisa menggunakan kurung kurawal {}
 */
 
require_once "groupUseDeclaration/Datas_NamespaceGroup.php";
require_once "namespace/Conflict.php";
 
use Data\One\{
 Pertama as Satu,
 Kedua as Dua,
 Ketiga as Tiga,
 Conlflict as Con
};
use function Data\Dummy\{sapa};
use const Data\Dummy\{APPLICATION};

echo var_dump(new Satu());
echo var_dump(new Con());
sapa();
echo APPLICATION .PHP_EOL;

 
 