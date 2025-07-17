<?php

class Pet {
  var string $name;
  var int $age;
  
  function __construct(string $name, int $age) {
    $this->name = $name;
    $this->age = $age;
  }
}

class Cat extends Pet{
  var string $color;
  
  function __construct(string $name, int $age, string $color) {
    parent::__construct($name, $age);
    $this->color = $color;
  }
}
