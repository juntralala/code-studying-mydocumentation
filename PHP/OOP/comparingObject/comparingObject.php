<?php
/**
 * Sama sepertti tipe data lainya, kalau mau membandingkan object, digunakan operator
   == (equals) dan === (identity)
 * Operator equals (==) membandingkan semua properties yang terdapat di antar 2 object, dan
   tiap properties aka n dibandingkan juga menggunakan operator equals (==)
 * Operator Identity (===) membadingkan apakah mengacu kepada object yang sama (pada memory)
*/

require_once "objectCloning/Student.php";

$murid1 = new Student("S3033", "Dayat", 16);
$murid2 = new Student("S3033", "Dayat", 16);

echo var_dump($murid1 == $murid2);
echo var_dump($murid1 === $murid2);
echo var_dump($murid1 === $murid1);