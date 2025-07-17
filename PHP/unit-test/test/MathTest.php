<?php

use UjunAlRantaui\UnitTest\Math;

class MathTest extends PHPUnit\Framework\TestCase{

    // contoh manual / tanpa @dataProvider
    public function testManual(){
        self::assertEquals(10, Math::sum([5, 5]));
        self::assertEquals(16, Math::sum([4, 4, 4, 4]));
        self::assertEquals(9, Math::sum([3, 3, 3]));
        self::assertEquals(0, Math::sum([]));
        self::assertEquals(2, Math::sum([2]));
        self::assertEquals(4, Math::sum([2, 2]));
    }

    // Contoh @dataProvider START
    static public function mathSumData():array {
        return [
            [[5, 5], 10],
            [[4, 4, 4, 4], 16],
            [[3, 3, 3], 9],
            [[], 0],
            [[2], 2],
            [[2, 2], 4],
        ];
    }

    /** 
     * @dataProvider mathSumData 
     */
    public function testDataProvider(array $values, int $expected){
        self::assertEquals($expected, Math::sum($values));
    }
    // Contoh @dataProvider END

    /**
     * @testWith [[5, 5], 10]
     *           [[4, 4, 4, 4], 16]
     *           [[3, 3, 3], 9]
     *           [[], 0]
     *           [[2], 2]
     *           [[2, 2], 4]
     */
    public function testTestWith(array $values, int $expected){
        self::assertEquals($expected, Math::sum($values));
    }
}