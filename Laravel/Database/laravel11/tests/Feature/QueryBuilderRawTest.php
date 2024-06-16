<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class QueryBuilderRawTest extends TestCase {
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

    public function testRawSql(): void {
        $this->insertSomeCategories();
        $this->insertSomeProducts();
        $collection = DB::table('products')
            ->select([
                DB::raw('COUNT(*) AS total_price'),
                DB::raw('MIN(price) AS min_price'),
                DB::raw('MAX(price) AS max_price')
            ])
            ->get();

        self::assertEquals(2, $collection[0]->total_price);
        self::assertEquals(18_000_000, $collection[0]->min_price);
        self::assertEquals(20_000_000, $collection[0]->max_price);
    }
}
