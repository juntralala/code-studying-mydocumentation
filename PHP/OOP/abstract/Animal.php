<?php

abstract class Animal {
  abstract public function run():void;
}

class Cat extends Animal{
  public function run():void {
    echo "Cat is Run" .PHP_EOL;
  }
}