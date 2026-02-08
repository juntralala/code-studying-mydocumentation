<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Carbon\Carbon;

// dari date time
// carbonize perlu instance object, return new instance
$tanggal = Carbon::create()->carbonize(new DateTime('2024-03-01 08:40:10.123'));
echo $tanggal->toISOString() . PHP_EOL;

/*
carbonize() nggak cuman nerima DateTime tapi banyak lainnya,
seperti:
CarbonInterval
CarbonPeriod
*/



// Carbon ke date time
$nativeTime = Carbon::now()->toDate();
