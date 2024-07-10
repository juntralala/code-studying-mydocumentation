<?php

namespace Tests\Feature\Relations;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class QueryingRelationsTest extends TestCase
{
    public function testQueryingRelations(): void
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);

        $category = Category::find("FOOD");
        $products = $category->products()->where("price", 100)->get();

        self::assertCount(1, $products);
    }
}
