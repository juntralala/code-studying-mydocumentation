<?php
/*
beberapa fungsi array :
1. array_keys()         mengambil semua keys milik array
2. array_values()       mengambil semua values milik array
3. array_map()          mengambil semua data array dengan callback
4. sort()               mengurutkan array
5. rsort()              mengurutkan array terbalik
6. shuffle()            megubah posisi array secara random 
*/

$datas = [1,2,3,4,5,6,7,8,9,10];

$dikali10 = fn(int $value) => $value * 10 ;

var_dump(array_map( $dikali10, $datas));

var_dump(array_keys($datas));
var_dump(array_values($datas));

sort($datas);
var_dump($datas);

rsort($datas);
var_dump($datas);

shuffle($datas);
var_dump($datas);
