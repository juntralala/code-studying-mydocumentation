<?php 
/**
 * Abstract function adalah function yang tidak memilik block/body dan harus di override oleh turunan class nya
 * Abstract function tidak boleh memiliki access modifier provate, jadi hanya boleh public dan protected
 * Abstract function cuman bisa diletakkan didalam abstract class
 */

require_once "Animal.php";

$oren = new Cat();

$oren->run();