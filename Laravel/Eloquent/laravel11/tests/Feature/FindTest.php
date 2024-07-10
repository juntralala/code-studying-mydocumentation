<?php

namespace Tests\Feature;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class FindTest extends TestCase
{
    public function testFind(): void
    {
        $this->seed(CategorySeeder::class);

        // $category = $category = Category::query()->find("FOOD");
        $category = $category = Category::find("FOOD");

        self::assertEquals("FOOD", $category->id);
        self::assertEquals("Food", $category->name);
        self::assertEquals("Food Category", $category->description);
    }
}
