<?php

require_once "SayHello.php";
require_once "SayGoodbye.php";
require_once "HashName.php";
require_once "CanRun.php";

class Person {
  use SayHello ,SayGoodbye, HashName, CanRun {
    sayHello as private;
  }
  
  function sapa(string $name) {
    $this->sayHello($name);
  }
  
  function run() {
    echo "Person is Run" .PHP_EOL;
  }
}