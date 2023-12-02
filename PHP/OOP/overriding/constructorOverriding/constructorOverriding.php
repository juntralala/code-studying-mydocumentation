<?php

require_once "Pet.php";

$pet = new Pet("Utuh", 2);
echo var_dump($pet);

$cat = new Cat("Aluh", 2, "Belang 3");
echo var_dump($cat);