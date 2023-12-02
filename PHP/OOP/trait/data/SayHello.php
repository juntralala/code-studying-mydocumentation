<?php

trait SayHello {
  function sayHello(string $name){
    echo "Hallo $name" .PHP_EOL;
  }
}