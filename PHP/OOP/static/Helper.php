<?php

namespace Helper;

class Helper {
  public static string $name;
  
  public static function sum(int... $numbers):int {
    $hasil = 0;
    for ($i=0; $i<count($numbers) ; $i++) $hasil += $numbers[$i];
    return $hasil;
  }
}