<?php

namespace App\Data;

class Orang {
    public string $name;

    public function __construct(string $name){
        $this->name = $name;
    }
}
