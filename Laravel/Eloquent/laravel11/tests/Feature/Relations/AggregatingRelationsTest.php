<?php

namespace Tests\Feature\Relations;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class AggregatingRelationsTest extends TestCase
{
    public function testQueryingRelationsAggregate(): void
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class, Product2Seeder::class]);

        $category = Category::find("FOOD");
        $totalProducts  = $category->products()->count();
        self::assertEquals(2, $totalProducts);
    }
}
