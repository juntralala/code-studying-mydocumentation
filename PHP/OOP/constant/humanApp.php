<?php

include_once "Human.php";

$ujun = new Human();
$ujun->name = "Muhammad Junaidi";

echo "Pencipta : ".Human::AUTHOR .PHP_EOL;
// echo "Pencipta : ".$ujun->AUTHOR; // ini error
echo "Nama     : ".$ujun->name  .PHP_EOL ;