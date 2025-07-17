<?php
/**
 * Kebalikan covariance
 * Contravariance adalah memperbolehkan child class untuk membuat fubnction arguments yang lebih tidak spesifik dibandung parentnya
 */

require_once "Animal.php";
require_once "Food.php";

$cat = new Cat();
$dog = new Dog();

$cat->eat(new Food());
$dog->eat(new AnimalFood());