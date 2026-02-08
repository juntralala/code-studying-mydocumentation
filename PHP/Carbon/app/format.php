<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Carbon\Carbon;

$now = Carbon::now();
// pakai isoFormat() dari Carbon : https://carbon.nesbot.com/guide/getting-started/localization.html
// isoFormat() mendukung nama hari dan bulan pakai bahasa indonesia (lokalisasi), sedangkan format() tidak
echo $now->isoFormat('dddd, DD-MM-YYYY HH:mm:ss.SSS') . PHP_EOL;

// pakai format() dari DateTime class
echo $now->format('l, d-m-Y h:m:s.v') . PHP_EOL;

// ada beberapa method, untuk format yang sering dipakai toXXXString()
echo $now->toISOString() . PHP_EOL;
echo $now->toAtomString() . PHP_EOL;
echo $now->toCookieString() . PHP_EOL;