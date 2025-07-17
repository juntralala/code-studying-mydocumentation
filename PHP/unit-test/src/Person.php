<?php

namespace UjunAlRantaui\UnitTest;

use Exception;

class Person {
    public function __construct(private string $name) {
    }

    public function sayHello(?string $name){
        if($name == null) throw new Exception("Name is Null");
        
        return "Hello $name, my name is $this->name";
    }

    public function sayGoodbye($name){
        echo "Good bye $name" . PHP_EOL;
    }
}