<?php
// interface tidak boleh memiliki properties, tapi const boleh
 
 require_once "Tranportation.php";
 
 $mobil = new Car();
 
 $mobil->drive();
 $mobil->stop();