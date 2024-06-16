<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class PaginationTest extends TestCase {
    public function setUp(): void {
        parent::setUp();
        DB::table('products')->delete();
        DB::table('categories')->delete();

        $this->insertSomeCategories();
        $this->insertSomeProducts();
        $this->insertFoodProducts();
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

    public function testPaginate(): void {
        $paginate = DB::table('products')->paginate(perPage: 2, page: 1);

        self::assertEquals(1, $paginate->currentPage());
        self::assertEquals(2, $paginate->perPage());
        self::assertEquals(2, $paginate->lastPage());
        self::assertEquals(4, $paginate->total());

        $array = $paginate->items();
        foreach ($array as $item) {
            Log::info(json_encode($item));
        }
    }

    public function testIteratePagination(): void {
        for($page = 1 ; true ; $page++){
            $paginate = DB::table('products')->paginate(perPage: 2, page: $page);
            if($paginate->isEmpty()){
                break;
            } else {
                foreach($paginate->items() as $item){
                    self::assertNotNull($item);
                    Log::info(json_encode($item));
                }
            }
        }
    }
}
