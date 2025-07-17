<?php

$nilai = 60;

if ($nilai >= 80)
    echo "Nilai kamu A" . PHP_EOL;
else if ($nilai >= 70) 
    echo "Nilai kamu B" . PHP_EOL;
elseif ($nilai >= 60)
    echo "Nilai kamu C" . PHP_EOL;
else 
    echo "Nilai Kamu D" . PHP_EOL;

if ($nilai >= 80) {
    echo "selamat" . PHP_EOL;
    echo "Nilai kamu A" . PHP_EOL;
}else if ($nilai >= 70) {
    echo "selamat" . PHP_EOL;
    echo "Nilai kamu B" . PHP_EOL;
} elseif ($nilai >= 60) {
    echo "selamat" . PHP_EOL;
    echo "Nilai kamu C" . PHP_EOL;
}
else {
    echo "selamat" . PHP_EOL;
    echo "Nilai Kamu D" . PHP_EOL;
}

// opsi :
/*
ketika kita menggnakan : pada if statement kita perlu menambahkan
endif pada akhiran nya
*/
if ($nilai >= 80) :
    echo "selamat" . PHP_EOL;
    echo "Nilai kamu A" . PHP_EOL;
elseif ($nilai >= 70) :
    echo "selamat" . PHP_EOL;
    echo "Nilai kamu B" . PHP_EOL;
 elseif ($nilai >= 60) :
    echo "selamat" . PHP_EOL;
    echo "Nilai kamu C" . PHP_EOL;
else :
    echo "selamat" . PHP_EOL;
    echo "Nilai Kamu D" . PHP_EOL;
endif;




