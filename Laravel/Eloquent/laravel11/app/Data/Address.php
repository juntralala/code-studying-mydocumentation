<?php

namespace App\Data;

class Address
{
    public function __construct(
        public string $street,
        public string $city,
        public string $country,
        public string $postalCode,
    ) {
        
    }
}
