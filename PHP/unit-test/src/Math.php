<?php

namespace UjunAlRantaui\UnitTest;

class Math{
    static public function sum(array $numbers):int {
        $totals = 0;
        foreach($numbers as $number){
            $totals += $number;
        }
        return $totals;
    }
}