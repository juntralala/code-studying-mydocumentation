<?php

class Product {
  var string $id;
  var string $name;
  
  public function __construct(string $id, string $name) {
    $this->id = $id;
    $this->name = $name;
  }
}