<?php
/*
operator array 6:
1. $a + $b      union           menggabungkan array $a + $b
2. $a == $b     equality        key dan value sama
3. $a === $b    identity        key dan value sama dan posisi sama
4. $a != $b     inequality      tidak sama
5. $a <> $b     inequality      tidak sama
6. $a !== $b    nondentity      tidak indentik
*/

$first = [1,2,3];
$second = [4,5,6,7];

$union    = $first + $second;
var_dump($union);               // jika key/index sama maka salah satunya akan di ignore 

$first = [
    "firstName" => "Muhammad" 
];
$last = [
    "firstName"=> "Ahmad",
    "lastName" => "Junaidi"
];

$full = $first + $last; // jika key double maka salah satu nya akan di ignore
var_dump($full);

