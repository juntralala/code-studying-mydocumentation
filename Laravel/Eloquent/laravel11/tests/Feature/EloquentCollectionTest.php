<?php

namespace Tests\Feature;

use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class EloquentCollectionTest extends TestCase
{
    public function testEloquentCollection(): void
    {
        $this->seed([
            CategorySeeder::class,
            ProductSeeder::class,
            Product2Seeder::class
        ]);

        $products = Product::get();
        self::assertCount(2, $products); 

        $query = $products->toQuery(); // menghasilkan query dengan : WHERE id IN (...)
        
        // query : SELECT * FROM product WHERE id IN (?, ?) AND price = 200;
        $results = $query->where("price", '200')->get();

        self::assertEquals(2, $results[0]->id);
    }
}
