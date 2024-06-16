<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class QueryBuilderHavingTest extends TestCase {
    public function setUp(): void {
        parent::setUp();
        DB::table('products')->delete();
        DB::table('categories')->delete();
    }
    
    public function tearDown(): void {
        DB::table('products')->delete();
        DB::table('categories')->delete();
        parent::tearDown();
    }

    public function insertSomeCategories(): void {
        DB::table('categories')->insert(['id' => "BOOK", 'name' => "Book", 'created_at' => "2024-06-12 00:00:00"]);
        DB::table('categories')->insert(['id' => "FOOD", 'name' => "Food", 'created_at' => "2024-06-12 00:00:00"]);
        DB::table('categories')->insert(['id' => "SMARTPHONE", 'name' => "Smartphone", 'created_at' => "2024-06-12 00:00:00"]);
        DB::table('categories')->insert(['id' => "FASHION", 'name' => "Fashion", 'created_at' => "2024-06-12 00:00:00"]);
    }

    public function insertSomeProducts(): void {
        DB::table('products')->insert([
            'id' => "1",
            'name' => "iPhone 14 Pro Max",
            'category_id' => "SMARTPHONE",
            'price' => 20_000_000
        ]);
        DB::table('products')->insert([
            'id' => "2",
            'name' => "Samsung Galaxy S21 Ultra",
            'category_id' => "SMARTPHONE",
            'price' => 18_000_000
        ]);
    }

    public function insertFoodProducts(): void {
        DB::table('products')->insert([
            'id' => "3",
            'name' => "Mie Ayam",
            'category_id' => "FOOD",
            'price' => 20_000
        ]);
        DB::table('products')->insert([
            'id' => "4",
            'name' => "Bakso",
            'category_id' => "FOOD",
            'price' => 20_000
        ]);
    }

    public function testHaving(): void {
        $this->insertSomeCategories();
        $this->insertSomeProducts();
        $this->insertFoodProducts();

        $collection = DB::table('products')
            ->select(['category_id', DB::raw("COUNT(*) AS total_category")])
            ->groupBy('category_id')
            ->orderBy('category_id', 'desc')
            ->having('total_category', '>', 2)
            ->get();
        self::assertCount(0, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }
}
