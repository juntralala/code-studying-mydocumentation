<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;
use Illuminate\Support\LazyCollection;

class LazyCollectionTest extends TestCase {
    public function testLazyCollection(): void {
        $collection = LazyCollection::make(function(){
            $value = 0;
            while(true){
                yield $value;
                $value++;
                if ($value > PHP_INT_MAX) break; // baris kutambahkan karna ada warning dari PHP Intellisense, harusnya baris ini tidak ada
            } // kelihatanya seperti infinte loop, tapi karan kita pakai yield tidak
        });

        $result = $collection->take(10);
        self::assertEqualsCanonicalizing([0,1,2,3,4,5,6,7,8,9], $result->all());
    }
}
