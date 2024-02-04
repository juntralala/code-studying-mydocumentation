<?php

class Hero{
    public function __construct(private $name, private $role){
    }
}

class Marksman extends Hero {
    public function __construct($name){
        $this->name = $name;
        $this->role = "Marksman";
    }
}

var_dump(new Marksman("Miya"));

