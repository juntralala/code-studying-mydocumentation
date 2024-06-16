<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class ChunkTest extends TestCase {
    public function setUp(): void {
        parent::setUp();
        DB::table('products')->delete();
        DB::table('categories')->delete();
        
        $help = new QueryBuilderOrderingTest(self::class);
        $help->insertSomeCategories();
        $help->insertSomeProducts();
    }
        
    public function tearDown(): void {
        DB::table('products')->delete();
        DB::table('categories')->delete();
        parent::tearDown();
    }

    public function testChunk(): void {
        DB::table('categories')
            ->orderby('id')
            ->chunk(2, function($categories){
                self::assertCount(2, $categories);
                $categories->each(fn($item) => Log::info(json_encode($item)));
            });
    }


}
