<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Carbon\Carbon;

$dt = Carbon::create(2020, 5, 21, 0, 0, 0, 'UTC');

echo $dt . PHP_EOL;
$dt->year += 2;
$dt->month++;
$dt->day = 3;
$dt->second = 130; // <- menyebabkan $dt->minute += 2 
echo $dt .PHP_EOL; 

$dt->timezone = 'Asia/Makassar';
echo $dt . PHP_EOL;