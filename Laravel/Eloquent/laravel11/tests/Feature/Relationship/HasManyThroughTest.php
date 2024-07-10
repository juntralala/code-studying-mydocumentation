<?php

namespace Tests\Feature\Relationship;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Database\Seeders\ReviewSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class HasManyThroughTest extends TestCase
{

    public function testHasManyThrough(): void
    {
        $this->seed([
            CategorySeeder::class,
            ProductSeeder::class,
            Product2Seeder::class,
            CustomerSeeder::class,
            ReviewSeeder::class
        ]);
        $category = Category::find("FOOD");
        self::assertNotNull($category);
        $reviews = $category->reviews;
        self::assertNotNull($reviews);
        self::assertCount(2, $reviews);
    }
}
