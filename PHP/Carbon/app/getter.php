<?php
require_once __DIR__ . '/../vendor/autoload.php';

use Carbon\Carbon;

/**
 * Carbon pakai __get() agar bisa ngambil data tanpa method (meski nggak semua sih, timestamp milis harus pakai method)
 * 
 * lebih banyak contoh ada di docs: https://carbon.nesbot.com/guide/core-api/setters.html
 */


$tanggal = Carbon::now();
echo $tanggal . PHP_EOL; // <- pake __tostring(), <- pake timezone yang ada pada instance, default UTC
echo $tanggal->century . PHP_EOL;
echo $tanggal->year . PHP_EOL;
echo $tanggal->month . PHP_EOL;
echo $tanggal->day . PHP_EOL;
echo $tanggal->minute . PHP_EOL;
echo $tanggal->second . PHP_EOL;
echo $tanggal->timestamp . PHP_EOL; // <- second timestamp
echo $tanggal->getTimestampMs() . PHP_EOL; // <- milis timestamp

echo $tanggal->dayOfWeek . PHP_EOL; // <- dihitung mulai angka 0 dan mulai hari minggu
echo $tanggal->daysInMonth . PHP_EOL; // total jumlah hari di bulan ini

// untuk pengambilan secara dynamic:
echo $tanggal->get('second') . PHP_EOL;
echo $tanggal->get('year') . PHP_EOL;


echo 'hari ini:' . $tanggal->isToday() . PHP_EOL;
echo 'besok:' . $tanggal->isTomorrow() . PHP_EOL;
echo 'masa depan:' . $tanggal->isFuture() . PHP_EOL;
echo 'masa lalu:' . $tanggal->isPast() . PHP_EOL;
