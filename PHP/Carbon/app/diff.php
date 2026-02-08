<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Carbon\Carbon;

$before = Carbon::now()
    ->subYears(5)
    ->subMonths(8)
    ->subDays(20);
$now = Carbon::now();

$selisih = $now->diff($before); 
echo($selisih);