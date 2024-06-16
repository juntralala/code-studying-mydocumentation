<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use PHPUnit\Framework\Attributes\DoesNotPerformAssertions;
use Tests\TestCase;

class LazyTest extends TestCase {
    public function setUp(): void {
        parent::setUp();
        $help = new ChunkTest(self::class);
        $help->setUp();
    }

    #[DoesNotPerformAssertions]
    public function testLazy(): void {
        $collection = DB::table('categories')
            ->orderby('id')
            ->lazy(2);
        
         $collection->each(function($item){
            Log::info(json_encode($item));
         });
    }
}
