<?php

/**
 * const sifatnya todak bisa dirubah, karna itu const tidak menempel pada object melainkan class
 * jadi, cara mengaksesnya lewat class bukan object
*/

class Human {
  const AUTHOR = "Allah";
  
  var string $name;
  var string $age;
  var string $address;
}