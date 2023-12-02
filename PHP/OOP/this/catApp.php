<?php

include_once "Cat.php";

$cat = new Cat();

$cat->name = "Urik";
$cat->age = 3;
$cat->color = "orange";

echo var_dump($cat);

$cat->sayHello(null);
$cat->sayHello("ujun");