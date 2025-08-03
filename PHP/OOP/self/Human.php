<?php

class Human {
  const AUTHOR = "Allah";
  
  var string $name;
  var string $age;
  var string $address;
  
  function pray() {
    echo "Hai tuhanku, Ya " .self::AUTHOR .PHP_EOL;
  }
}