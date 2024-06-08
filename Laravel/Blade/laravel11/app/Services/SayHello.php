<?php

namespace App\Services;

class SayHello {

    public function hello(string $name): string {
        return "Hello $name";
    }

}