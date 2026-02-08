<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Carbon\Carbon;

/**
 * Karna Carbon itu extend DateTime bawaan PHP, jadi mendukung perbandingan dengan operator langsung
 * DateTime itu bawaan php, dan sudah diatur dengan C agar bisa pakai oprator dalam perbandingan
 */

$now = Carbon::now();
$tomorrow = Carbon::now()->addDays(1);

var_dump($now == $tomorrow);
var_dump($now != $tomorrow);
var_dump($now < $tomorrow);
var_dump($now > $tomorrow);
var_dump($now <= $tomorrow);
var_dump($now >= $tomorrow);

// pakai method juga bisa
var_dump($now->equalTo($tomorrow));
var_dump($now->notEqualTo($tomorrow)); 
var_dump($now->greaterThan($tomorrow)); 
var_dump($now->lessThan($tomorrow)); 
var_dump($now->greaterThanOrEqualTo($tomorrow)); 
var_dump($now->lessThanOrEqualTo($tomorrow)); 

// method alias
var_dump($now->eq($tomorrow));
var_dump($now->ne($tomorrow)); 
var_dump($now->gt($tomorrow)); 
var_dump($now->lt($tomorrow)); 
var_dump($now->gte($tomorrow)); 
var_dump($now->lte($tomorrow)); 