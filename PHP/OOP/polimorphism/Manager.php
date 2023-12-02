<?php

class Manager{
  var string $name;
  
  function sayHello(string $name):void {
    echo "hello $name, myname is $this->name\n";
  }
}

class VisePresident extends Manager{}

class President extends VisePresident {}
