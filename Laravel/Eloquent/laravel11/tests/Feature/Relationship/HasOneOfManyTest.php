<?php

namespace Tests\Feature\Relationship;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class HasOneOfManyTest extends TestCase
{
    public function testHasOneOfMany(): void
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class, Product2Seeder::class]);

        $category = Category::find("FOOD");
        self::assertNotNull($category);

        $cheapestProduct = $category->cheapestProduct;
        self::assertNotNull($cheapestProduct);
        self::assertEquals('1', $cheapestProduct->id);
        
        $mostExpensiveProduct = $category->mostExpensiveProduct;
        self::assertNotNull($mostExpensiveProduct);
        self::assertEquals('2', $mostExpensiveProduct->id);
    }
}
