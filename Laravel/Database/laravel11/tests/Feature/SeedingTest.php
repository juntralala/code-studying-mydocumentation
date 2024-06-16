<?php

namespace Tests\Feature;

use Database\Seeders\CategorySeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class SeedingTest extends TestCase {
    public function setUp(): void {
        parent::setUp();
        DB::table('products')->delete();
        DB::table('categories')->delete();
    }

    public function testSeed(): void {
        $this->seed(CategorySeeder::class);
        
        $collection = DB::table('categories')->get();
        self::assertCount(4, $collection);
    }
}
