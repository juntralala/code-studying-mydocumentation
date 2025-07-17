<?php

namespace UjunAlRantaui\UnitTest;

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

    // contoh test annotation @test
    /**
     * @test
     */
    public function counter() {
        $counter = new Counter();
        $counter->increment();
        self::assertEquals(1, $counter->getCounter());
    }
    
    // <============= contoh Test Depedency START =============>
    public function testFirst():Counter {
        $counter = new Counter();
        $counter->increment();
        self::assertEquals(1, $counter->getCounter());
        return $counter;
    }
    
    /**
     * @depends testFirst
     */
    public function testSecond(Counter $counter):void {
        $counter->increment();
        self::assertEquals(2, $counter->getCounter());
    }
    // <============= contoh Test Depedency END =============>
}
