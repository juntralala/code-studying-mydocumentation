<?php

require_once __DIR__."/vendor/autoload.php";

$costumer = new \UjunAlRantaui\Belajar\Costumer("Ujun");

echo $costumer->getName() . PHP_EOL;

echo $costumer->sapa("Dawi") . PHP_EOL;