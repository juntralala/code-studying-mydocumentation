<?php

class Cat {
  var string $name;
  var int $age;
  var string $color;
  
  function sayHello(?string $name) {
    if (is_null($name)) echo "hello my name is $this->name".PHP_EOL;
    else echo "hello, $name".PHP_EOL;
  }
}