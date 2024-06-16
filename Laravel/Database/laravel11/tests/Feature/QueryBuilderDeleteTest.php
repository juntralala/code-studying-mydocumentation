<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use PHPUnit\Framework\Attributes\Depends;
use Tests\TestCase;

class QueryBuilderDeleteTest extends TestCase {

    public function setUp(): void {
        parent::setUp();
        DB::delete("DELETE FROM categories");
        $this->insertSomeCategories();
    }

    public function insertSomeCategories(): void {
        DB::table('categories')->insert(['id' => "BOOK", 'name' => "Book", 'created_at' => "2024-06-12 00:00:00"]);
        DB::table('categories')->insert(['id' => "FOOD", 'name' => "Food", 'created_at' => "2024-06-12 00:00:00"]);
        DB::table('categories')->insert(['id' => "SMARTPHONE", 'name' => "Smartphone", 'created_at' => "2024-06-12 00:00:00"]);
        DB::table('categories')->insert(['id' => "FASHION", 'name' => "Fashion", 'created_at' => "2024-06-12 00:00:00"]);
    }

    public function testDelete(): void {
        DB::table('categories')
            ->where('id', '=', 'SMARTPHONE')
            ->delete();
        $collection = DB::table('categories')->get();
        self::assertCount(3, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }
    
    public function testTruncate(): void {
        self::markTestSkipped("testTruncate dinoaktifkan karna sudah ada table yg ngereferance ke table yg ditruncate");
        if(DB::getDriverName() == "sqlite"){
            self::markTestSkipped("SQLite tidak mendukung perintah truncate");
        }
        
        DB::table('categories')
            ->truncate();
        $collection = DB::table('categories')->get();
        self::assertCount(0, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }
}
