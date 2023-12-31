<?php

namespace UjunAlRantaui\UnitTest;

require_once __DIR__."/../vendor/autoload.php";

use PHPUnit\Framework\TestCase;
use PHPUnit\Framework\Assert;

class CounterTest extends TestCase{

    public function testCounter() {
        $counter = new  Counter();
        $counter->increment();
        Assert::assertEquals(1, $counter->getCounter()); // ada 3 cara menggunakan assertions, tidak ada
        $this::assertEquals(1, $counter->getCounter());  // cara terbaik diantara ketiganya, jadi  
        self::assertEquals(1, $counter->getCounter());   // ketiganya optional / bebas
    }

    // public function testOther() {
    //     echo "this is Other\n";
    // }


}
