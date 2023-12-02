<?php

include_once "Person.php";

$orang  = new Person();

$orang->nama = "ujun";
$orang->umur = 19; 
$orang->alamat = "Handil Rantau"; 

echo var_dump($orang);
