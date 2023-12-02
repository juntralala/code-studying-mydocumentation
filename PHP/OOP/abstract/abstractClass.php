<?php
/**
 * Absract class adalah class yang hanya bisa diwariskan, jadi tidak bisa dibuatkan objectnya secara langsung
 * Jika kita ingin membuat sebuah object dari abstract class, kita harus membuat class turunan dari abstract class tersebut, maka kita harus membuat class turunannya
*/

require_once "Location.php";
use Data\{Location, City, Province, Country};

// $location = new Location();

$location = new City();
$location = new Province();
$location = new Country();
 
 echo "semua seukses";