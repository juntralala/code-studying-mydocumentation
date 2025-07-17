<?php

interface Transportation {
 const PENCETUS = "IDK";
  function drive();
  
  function stop();
}

class Car implements Transportation {
  
  function drive() {
    echo "Car is Driving" .PHP_EOL;
  }
  
  function stop(){
    echo "Car is stopped" .PHP_EOL;
  }
}