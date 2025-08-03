<?php

namespace UjunAlRantaui\Data;

class People {
    public function __construct(public string $name,
                                public int $age) {
    }

    public function intro() {
        echo "My name is $this->name, my age is $this->age" . PHP_EOL;
    }
}