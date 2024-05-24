<?php

namespace App\Services;

interface HelloService {
    function hello(string $name): string;
}